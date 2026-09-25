package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.local.AddressEntity
import com.example.data.local.CartItemEntity
import com.example.data.local.FavoriteEntity
import com.example.data.local.OrderEntity
import com.example.data.local.UserProfileEntity
import com.example.data.model.Coupon
import com.example.data.model.Dish
import com.example.data.model.OrderStatus
import com.example.data.model.Restaurant
import com.example.data.model.TableBooking
import com.example.data.repository.ZomatoRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class MainTab {
    DELIVERY,
    DINING,
    GOLD,
    ORDERS
}

class ZomatoViewModel(
    private val repository: ZomatoRepository
) : ViewModel() {

    // Tab Navigation
    private val _currentTab = MutableStateFlow(MainTab.DELIVERY)
    val currentTab: StateFlow<MainTab> = _currentTab.asStateFlow()

    // Sub-Screen Navigation (Restaurant Detail, Cart, Order Tracking)
    private val _selectedRestaurant = MutableStateFlow<Restaurant?>(null)
    val selectedRestaurant: StateFlow<Restaurant?> = _selectedRestaurant.asStateFlow()

    private val _activeTrackingOrderId = MutableStateFlow<String?>(null)
    val activeTrackingOrderId: StateFlow<String?> = _activeTrackingOrderId.asStateFlow()

    private val _isCartOpen = MutableStateFlow(false)
    val isCartOpen: StateFlow<Boolean> = _isCartOpen.asStateFlow()

    // Search and Filters
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCuisine = MutableStateFlow("All")
    val selectedCuisine: StateFlow<String> = _selectedCuisine.asStateFlow()

    private val _isVegOnly = MutableStateFlow(false)
    val isVegOnly: StateFlow<Boolean> = _isVegOnly.asStateFlow()

    private val _minRating = MutableStateFlow(0f)
    val minRating: StateFlow<Float> = _minRating.asStateFlow()

    private val _fastDeliveryOnly = MutableStateFlow(false)
    val fastDeliveryOnly: StateFlow<Boolean> = _fastDeliveryOnly.asStateFlow()

    // Room Database Flows
    val activeUser: StateFlow<UserProfileEntity?> = repository.activeUser
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val cartItems: StateFlow<List<CartItemEntity>> = repository.allCartItems
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val orders: StateFlow<List<OrderEntity>> = repository.allOrders
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val favorites: StateFlow<List<FavoriteEntity>> = repository.allFavorites
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val addresses: StateFlow<List<AddressEntity>> = repository.allAddresses
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Cart details
    private val _appliedCoupon = MutableStateFlow<Coupon?>(null)
    val appliedCoupon: StateFlow<Coupon?> = _appliedCoupon.asStateFlow()

    private val _tipAmount = MutableStateFlow(2.0)
    val tipAmount: StateFlow<Double> = _tipAmount.asStateFlow()

    private val _cookingInstructions = MutableStateFlow("")
    val cookingInstructions: StateFlow<String> = _cookingInstructions.asStateFlow()

    // Dining Bookings
    private val _bookings = MutableStateFlow<List<TableBooking>>(emptyList())
    val bookings: StateFlow<List<TableBooking>> = _bookings.asStateFlow()

    // Dialog States
    private val _showAuthDialog = MutableStateFlow(false)
    val showAuthDialog: StateFlow<Boolean> = _showAuthDialog.asStateFlow()

    private val _isSignUpMode = MutableStateFlow(true)
    val isSignUpMode: StateFlow<Boolean> = _isSignUpMode.asStateFlow()

    private val _showEditProfileDialog = MutableStateFlow(false)
    val showEditProfileDialog: StateFlow<Boolean> = _showEditProfileDialog.asStateFlow()

    private val _tableBookingRestaurant = MutableStateFlow<Restaurant?>(null)
    val tableBookingRestaurant: StateFlow<Restaurant?> = _tableBookingRestaurant.asStateFlow()

    // Filtered restaurants
    val filteredRestaurants = combine(
        _searchQuery,
        _selectedCuisine,
        _isVegOnly,
        _minRating,
        _fastDeliveryOnly
    ) { query, cuisine, vegOnly, rating, fastDelivery ->
        val maxTime = if (fastDelivery) 25 else 999
        repository.searchRestaurants(
            query = query,
            cuisineFilter = cuisine,
            pureVegOnly = vegOnly,
            minRating = rating,
            maxDeliveryTime = maxTime
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), repository.getAllRestaurants())

    init {
        viewModelScope.launch {
            repository.initDefaultDataIfNeeded()
        }
    }

    fun selectTab(tab: MainTab) {
        _currentTab.value = tab
    }

    fun openRestaurant(restaurant: Restaurant) {
        _selectedRestaurant.value = restaurant
    }

    fun closeRestaurant() {
        _selectedRestaurant.value = null
    }

    fun openCart() {
        _isCartOpen.value = true
    }

    fun closeCart() {
        _isCartOpen.value = false
    }

    fun openOrderTracking(orderId: String) {
        _activeTrackingOrderId.value = orderId
        startLiveSimulation(orderId)
    }

    fun closeOrderTracking() {
        _activeTrackingOrderId.value = null
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectCuisine(cuisine: String) {
        _selectedCuisine.value = cuisine
    }

    fun toggleVegOnly() {
        _isVegOnly.value = !_isVegOnly.value
    }

    fun toggleFastDelivery() {
        _fastDeliveryOnly.value = !_fastDeliveryOnly.value
    }

    fun setMinRating(rating: Float) {
        _minRating.value = if (_minRating.value == rating) 0f else rating
    }

    fun resetFilters() {
        _searchQuery.value = ""
        _selectedCuisine.value = "All"
        _isVegOnly.value = false
        _minRating.value = 0f
        _fastDeliveryOnly.value = false
    }

    // User Profile & Auth
    fun openAuthDialog(isSignUp: Boolean) {
        _isSignUpMode.value = isSignUp
        _showAuthDialog.value = true
    }

    fun closeAuthDialog() {
        _showAuthDialog.value = false
    }

    fun openEditProfileDialog() {
        _showEditProfileDialog.value = true
    }

    fun closeEditProfileDialog() {
        _showEditProfileDialog.value = false
    }

    fun signUp(
        fullName: String,
        email: String,
        pass: String,
        address: String,
        phone: String,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            val result = repository.signUpUser(
                email = email,
                password = pass,
                fullName = fullName,
                deliveryAddress = address,
                phone = phone
            )
            if (result.isSuccess) {
                _showAuthDialog.value = false
            } else {
                onError(result.exceptionOrNull()?.message ?: "Sign up failed")
            }
        }
    }

    fun login(email: String, pass: String, onError: (String) -> Unit) {
        viewModelScope.launch {
            val result = repository.loginUser(email, pass)
            if (result.isSuccess) {
                _showAuthDialog.value = false
            } else {
                onError(result.exceptionOrNull()?.message ?: "Sign in failed")
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

    fun updateProfile(fullName: String, deliveryAddress: String, phone: String) {
        viewModelScope.launch {
            repository.updateUserProfile(fullName, deliveryAddress, phone)
            _showEditProfileDialog.value = false
        }
    }

    // Cart actions
    fun addDishToCart(dish: Dish, restaurant: Restaurant) {
        viewModelScope.launch {
            val existing = cartItems.value.find { it.dishId == dish.id }
            if (existing != null) {
                repository.updateCartItem(existing.copy(quantity = existing.quantity + 1))
            } else {
                repository.addItemToCart(dish, restaurant)
            }
        }
    }

    fun incrementCartItem(item: CartItemEntity) {
        viewModelScope.launch {
            repository.updateCartItem(item.copy(quantity = item.quantity + 1))
        }
    }

    fun decrementCartItem(item: CartItemEntity) {
        viewModelScope.launch {
            if (item.quantity <= 1) {
                repository.deleteCartItem(item.id)
            } else {
                repository.updateCartItem(item.copy(quantity = item.quantity - 1))
            }
        }
    }

    fun removeCartItem(itemId: Int) {
        viewModelScope.launch {
            repository.deleteCartItem(itemId)
        }
    }

    fun clearCart() {
        viewModelScope.launch {
            repository.clearCart()
        }
    }

    fun applyCoupon(coupon: Coupon) {
        _appliedCoupon.value = coupon
    }

    fun removeCoupon() {
        _appliedCoupon.value = null
    }

    fun setTipAmount(amount: Double) {
        _tipAmount.value = amount
    }

    fun setCookingInstructions(instructions: String) {
        _cookingInstructions.value = instructions
    }

    fun toggleFavorite(restaurant: Restaurant) {
        viewModelScope.launch {
            val isFav = favorites.value.any { it.restaurantId == restaurant.id }
            repository.toggleFavorite(restaurant, isFav)
        }
    }

    // Checkout and Order Placement
    fun placeOrder(onOrderPlaced: (String) -> Unit) {
        viewModelScope.launch {
            val items = cartItems.value
            if (items.isEmpty()) return@launch

            val restaurantName = items.first().restaurantName
            val restaurantId = items.first().restaurantId
            val summary = items.joinToString(", ") { "${it.quantity}x ${it.dishName}" }

            val itemTotal = items.sumOf { it.price * it.quantity }
            val deliveryFee = if (_appliedCoupon.value?.code == "GOLDFREE") 0.0 else 2.50
            val platformFee = 0.50
            val taxes = itemTotal * 0.08
            val discount = _appliedCoupon.value?.let {
                (itemTotal * (it.discountPercent / 100.0)).coerceAtMost(it.maxDiscount)
            } ?: 0.0
            val total = (itemTotal + deliveryFee + platformFee + taxes + _tipAmount.value - discount).coerceAtLeast(0.0)

            val user = activeUser.value
            val address = user?.deliveryAddress?.takeIf { it.isNotBlank() }
                ?: addresses.value.firstOrNull { it.isDefault }?.fullAddress
                ?: "104, Green Glen Heights, Bellandur, Bengaluru"

            val orderId = repository.placeOrder(
                userEmail = user?.email ?: "guest@example.com",
                restaurantName = restaurantName,
                restaurantId = restaurantId,
                itemsSummary = summary,
                totalAmount = total,
                deliveryAddress = address
            )

            _appliedCoupon.value = null
            _isCartOpen.value = false
            _selectedRestaurant.value = null
            openOrderTracking(orderId)
            onOrderPlaced(orderId)
        }
    }

    private fun startLiveSimulation(orderId: String) {
        viewModelScope.launch {
            delay(4000)
            repository.updateOrderStatus(orderId, OrderStatus.PREPARING)
            delay(6000)
            repository.updateOrderStatus(orderId, OrderStatus.OUT_FOR_DELIVERY)
            delay(12000)
            repository.updateOrderStatus(orderId, OrderStatus.DELIVERED)
        }
    }

    fun advanceOrderManually(orderId: String) {
        viewModelScope.launch {
            val order = orders.value.find { it.orderId == orderId } ?: return@launch
            val nextStatus = when (order.status) {
                OrderStatus.CONFIRMED.name -> OrderStatus.PREPARING
                OrderStatus.PREPARING.name -> OrderStatus.OUT_FOR_DELIVERY
                OrderStatus.OUT_FOR_DELIVERY.name -> OrderStatus.DELIVERED
                else -> OrderStatus.CONFIRMED
            }
            repository.updateOrderStatus(orderId, nextStatus)
        }
    }

    // Dining Table Booking
    fun openTableBooking(restaurant: Restaurant) {
        _tableBookingRestaurant.value = restaurant
    }

    fun closeTableBooking() {
        _tableBookingRestaurant.value = null
    }

    fun confirmTableBooking(
        restaurant: Restaurant,
        date: String,
        timeSlot: String,
        guests: Int,
        specialRequest: String
    ) {
        val booking = TableBooking(
            bookingId = "TBK-" + (1000 + (Math.random() * 9000).toInt()),
            restaurantName = restaurant.name,
            restaurantAddress = restaurant.address,
            date = date,
            timeSlot = timeSlot,
            guestsCount = guests,
            specialRequest = specialRequest,
            discount = restaurant.diningDiscount ?: "Flat 20% OFF with Gold"
        )
        _bookings.value = listOf(booking) + _bookings.value
        _tableBookingRestaurant.value = null
    }
}

class ZomatoViewModelFactory(
    private val repository: ZomatoRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ZomatoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ZomatoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
