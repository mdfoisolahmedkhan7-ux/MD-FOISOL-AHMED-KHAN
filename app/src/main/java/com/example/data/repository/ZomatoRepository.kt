package com.example.data.repository

import com.example.data.local.AddressDao
import com.example.data.local.AddressEntity
import com.example.data.local.CartDao
import com.example.data.local.CartItemEntity
import com.example.data.local.FavoriteDao
import com.example.data.local.FavoriteEntity
import com.example.data.local.OrderDao
import com.example.data.local.OrderEntity
import com.example.data.local.UserDao
import com.example.data.local.UserProfileEntity
import com.example.data.model.Dish
import com.example.data.model.OrderStatus
import com.example.data.model.Restaurant
import com.example.data.sample.SampleData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull

class ZomatoRepository(
    private val userDao: UserDao,
    private val cartDao: CartDao,
    private val orderDao: OrderDao,
    private val favoriteDao: FavoriteDao,
    private val addressDao: AddressDao
) {
    val activeUser: Flow<UserProfileEntity?> = userDao.getActiveUser()
    val allCartItems: Flow<List<CartItemEntity>> = cartDao.getAllCartItems()
    val allOrders: Flow<List<OrderEntity>> = orderDao.getAllOrders()
    val allFavorites: Flow<List<FavoriteEntity>> = favoriteDao.getAllFavorites()
    val allAddresses: Flow<List<AddressEntity>> = addressDao.getAllAddresses()

    fun getAllRestaurants(): List<Restaurant> = SampleData.restaurants

    fun getRestaurantById(id: String): Restaurant? {
        return SampleData.restaurants.find { it.id == id }
    }

    fun searchRestaurants(
        query: String,
        cuisineFilter: String = "All",
        pureVegOnly: Boolean = false,
        minRating: Float = 0f,
        maxDeliveryTime: Int = 999
    ): List<Restaurant> {
        return SampleData.restaurants.filter { rest ->
            val matchesQuery = query.isBlank() ||
                rest.name.contains(query, ignoreCase = true) ||
                rest.cuisines.any { it.contains(query, ignoreCase = true) } ||
                rest.menuCategories.any { cat ->
                    cat.dishes.any { it.name.contains(query, ignoreCase = true) }
                }

            val matchesCuisine = cuisineFilter == "All" ||
                rest.cuisines.any { it.equals(cuisineFilter, ignoreCase = true) }

            val matchesVeg = !pureVegOnly || rest.isPureVeg
            val matchesRating = rest.rating >= minRating
            val matchesTime = rest.deliveryTimeMin <= maxDeliveryTime

            matchesQuery && matchesCuisine && matchesVeg && matchesRating && matchesTime
        }
    }

    suspend fun signUpUser(
        email: String,
        password: String,
        fullName: String,
        deliveryAddress: String,
        phone: String
    ): Result<UserProfileEntity> {
        val existing = userDao.getUserByEmail(email.trim().lowercase())
        if (existing != null) {
            return Result.failure(Exception("An account with this email already exists."))
        }
        userDao.logoutAll()
        val newUser = UserProfileEntity(
            email = email.trim().lowercase(),
            passwordHash = password,
            fullName = fullName.trim(),
            deliveryAddress = deliveryAddress.trim(),
            phone = phone.trim(),
            isLoggedIn = true
        )
        userDao.insertUser(newUser)

        // Also add address to address book
        addressDao.insertAddress(
            AddressEntity(
                tag = "Home",
                fullAddress = deliveryAddress.trim(),
                landmark = "Primary Delivery Address",
                isDefault = true
            )
        )
        return Result.success(newUser)
    }

    suspend fun loginUser(email: String, password: String): Result<UserProfileEntity> {
        val user = userDao.getUserByEmail(email.trim().lowercase())
            ?: return Result.failure(Exception("No account found with this email."))
        if (user.passwordHash != password) {
            return Result.failure(Exception("Incorrect password. Please try again."))
        }
        userDao.logoutAll()
        userDao.setActiveUser(user.email)
        return Result.success(user.copy(isLoggedIn = true))
    }

    suspend fun logout() {
        userDao.logoutAll()
    }

    suspend fun updateUserProfile(fullName: String, deliveryAddress: String, phone: String) {
        val current = userDao.getActiveUser().firstOrNull() ?: return
        val updated = current.copy(
            fullName = fullName.trim(),
            deliveryAddress = deliveryAddress.trim(),
            phone = phone.trim()
        )
        userDao.updateUser(updated)
    }

    suspend fun addItemToCart(dish: Dish, restaurant: Restaurant, customization: String = "") {
        cartDao.insertItem(
            CartItemEntity(
                restaurantId = restaurant.id,
                restaurantName = restaurant.name,
                dishId = dish.id,
                dishName = dish.name,
                price = dish.price,
                quantity = 1,
                isVeg = dish.isVeg,
                customizationNote = customization
            )
        )
    }

    suspend fun updateCartItem(item: CartItemEntity) {
        if (item.quantity <= 0) {
            cartDao.deleteItemById(item.id)
        } else {
            cartDao.updateItem(item)
        }
    }

    suspend fun deleteCartItem(itemId: Int) {
        cartDao.deleteItemById(itemId)
    }

    suspend fun clearCart() {
        cartDao.clearCart()
    }

    suspend fun toggleFavorite(restaurant: Restaurant, isFav: Boolean) {
        if (isFav) {
            favoriteDao.removeFavorite(restaurant.id)
        } else {
            favoriteDao.addFavorite(
                FavoriteEntity(
                    restaurantId = restaurant.id,
                    restaurantName = restaurant.name
                )
            )
        }
    }

    suspend fun placeOrder(
        userEmail: String,
        restaurantName: String,
        restaurantId: String,
        itemsSummary: String,
        totalAmount: Double,
        deliveryAddress: String,
        estimatedMinutes: Int = 25
    ): String {
        val orderId = "ZOM-" + (100000 + (Math.random() * 900000).toInt())
        val orderEntity = OrderEntity(
            orderId = orderId,
            userEmail = userEmail,
            restaurantName = restaurantName,
            restaurantId = restaurantId,
            itemsSummary = itemsSummary,
            totalAmount = totalAmount,
            orderTimeMillis = System.currentTimeMillis(),
            status = OrderStatus.CONFIRMED.name,
            deliveryAddress = deliveryAddress,
            estimatedMinutes = estimatedMinutes
        )
        orderDao.insertOrder(orderEntity)
        cartDao.clearCart()
        return orderId
    }

    suspend fun updateOrderStatus(orderId: String, newStatus: OrderStatus) {
        orderDao.updateOrderStatus(orderId, newStatus.name)
    }

    suspend fun initDefaultDataIfNeeded() {
        // Initialize default user if none exists
        val currentUsers = userDao.getAllUsers().firstOrNull()
        if (currentUsers.isNullOrEmpty()) {
            val defaultUser = UserProfileEntity(
                email = "aarav.sharma@example.com",
                fullName = "Aarav Sharma",
                passwordHash = "password123",
                deliveryAddress = "104, Green Glen Heights, Bellandur, Bengaluru",
                phone = "+91 98765 43210",
                isLoggedIn = true
            )
            userDao.insertUser(defaultUser)

            // Seed addresses
            addressDao.insertAddress(
                AddressEntity(
                    id = 1,
                    tag = "Home",
                    fullAddress = "104, Green Glen Heights, Bellandur",
                    landmark = "Near EcoSpace Tech Park, Bengaluru",
                    isDefault = true
                )
            )
            addressDao.insertAddress(
                AddressEntity(
                    id = 2,
                    tag = "Work",
                    fullAddress = "Tower 3, Level 5, Global Technology Park",
                    landmark = "Outer Ring Road, Bengaluru",
                    isDefault = false
                )
            )

            // Seed past sample order with restaurant name, items ordered, total cost, and date
            val pastOrderTime = System.currentTimeMillis() - 86400000L * 2 // 2 days ago
            orderDao.insertOrder(
                OrderEntity(
                    orderId = "ZOM-739201",
                    userEmail = defaultUser.email,
                    restaurantName = "Behrouz Biryani",
                    restaurantId = "rest_1",
                    itemsSummary = "1x Shahi Dum Gosht Biryani, 1x Gulab Jamun (Pack of 2)",
                    totalAmount = 21.48,
                    orderTimeMillis = pastOrderTime,
                    status = OrderStatus.DELIVERED.name,
                    deliveryAddress = defaultUser.deliveryAddress,
                    estimatedMinutes = 25
                )
            )

            // Seed a second past order
            val pastOrderTime2 = System.currentTimeMillis() - 86400000L * 5 // 5 days ago
            orderDao.insertOrder(
                OrderEntity(
                    orderId = "ZOM-482195",
                    userEmail = defaultUser.email,
                    restaurantName = "Pizza Milano & Crusts",
                    restaurantId = "rest_2",
                    itemsSummary = "1x Classic Margherita Supreme, 1x Stuffed Garlic Breadsticks",
                    totalAmount = 18.98,
                    orderTimeMillis = pastOrderTime2,
                    status = OrderStatus.DELIVERED.name,
                    deliveryAddress = defaultUser.deliveryAddress,
                    estimatedMinutes = 20
                )
            )
        }
    }
}
