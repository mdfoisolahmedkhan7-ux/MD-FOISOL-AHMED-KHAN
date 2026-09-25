package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.local.AppDatabase
import com.example.data.repository.ZomatoRepository
import com.example.ui.components.BottomNavBar
import com.example.ui.screens.AuthDialog
import com.example.ui.screens.BookTableDialog
import com.example.ui.screens.CartScreen
import com.example.ui.screens.DeliveryHomeScreen
import com.example.ui.screens.DiningScreen
import com.example.ui.screens.EditProfileDialog
import com.example.ui.screens.GoldScreen
import com.example.ui.screens.OrderTrackingScreen
import com.example.ui.screens.ProfileOrdersScreen
import com.example.ui.screens.RestaurantDetailScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.MainTab
import com.example.ui.viewmodel.ZomatoViewModel
import com.example.ui.viewmodel.ZomatoViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = AppDatabase.getInstance(applicationContext)
        val repository = ZomatoRepository(
            userDao = database.userDao(),
            cartDao = database.cartDao(),
            orderDao = database.orderDao(),
            favoriteDao = database.favoriteDao(),
            addressDao = database.addressDao()
        )
        val viewModelFactory = ZomatoViewModelFactory(repository)

        setContent {
            MyApplicationTheme {
                val viewModel: ZomatoViewModel = viewModel(factory = viewModelFactory)
                ZomatoApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun ZomatoApp(viewModel: ZomatoViewModel) {
    val currentTab by viewModel.currentTab.collectAsStateWithLifecycle()
    val selectedRestaurant by viewModel.selectedRestaurant.collectAsStateWithLifecycle()
    val isCartOpen by viewModel.isCartOpen.collectAsStateWithLifecycle()
    val activeTrackingOrderId by viewModel.activeTrackingOrderId.collectAsStateWithLifecycle()
    val tableBookingRestaurant by viewModel.tableBookingRestaurant.collectAsStateWithLifecycle()

    val activeUser by viewModel.activeUser.collectAsStateWithLifecycle()
    val showAuthDialog by viewModel.showAuthDialog.collectAsStateWithLifecycle()
    val isSignUpMode by viewModel.isSignUpMode.collectAsStateWithLifecycle()
    val showEditProfileDialog by viewModel.showEditProfileDialog.collectAsStateWithLifecycle()

    val filteredRestaurants by viewModel.filteredRestaurants.collectAsStateWithLifecycle()
    val cartItems by viewModel.cartItems.collectAsStateWithLifecycle()
    val orders by viewModel.orders.collectAsStateWithLifecycle()
    val favorites by viewModel.favorites.collectAsStateWithLifecycle()
    val addresses by viewModel.addresses.collectAsStateWithLifecycle()

    val appliedCoupon by viewModel.appliedCoupon.collectAsStateWithLifecycle()
    val tipAmount by viewModel.tipAmount.collectAsStateWithLifecycle()
    val cookingInstructions by viewModel.cookingInstructions.collectAsStateWithLifecycle()
    val activeBookings by viewModel.bookings.collectAsStateWithLifecycle()

    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val selectedCuisine by viewModel.selectedCuisine.collectAsStateWithLifecycle()
    val isVegOnly by viewModel.isVegOnly.collectAsStateWithLifecycle()
    val minRating by viewModel.minRating.collectAsStateWithLifecycle()
    val fastDeliveryOnly by viewModel.fastDeliveryOnly.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val defaultAddress = activeUser?.deliveryAddress?.takeIf { it.isNotBlank() }
        ?: addresses.firstOrNull { it.isDefault }?.fullAddress
        ?: "104, Green Glen Heights, Bellandur, Bengaluru"

    val cartTotalAmount = cartItems.sumOf { it.price * it.quantity }
    val cartItemCount = cartItems.sumOf { it.quantity }

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            // Live Tracking Sub-Screen
            activeTrackingOrderId != null -> {
                val activeOrder = orders.find { it.orderId == activeTrackingOrderId }
                OrderTrackingScreen(
                    order = activeOrder,
                    onBack = { viewModel.closeOrderTracking() },
                    onAdvanceStatus = { orderId -> viewModel.advanceOrderManually(orderId) }
                )
            }

            // Cart & Checkout Sub-Screen
            isCartOpen -> {
                CartScreen(
                    cartItems = cartItems,
                    appliedCoupon = appliedCoupon,
                    tipAmount = tipAmount,
                    cookingInstructions = cookingInstructions,
                    deliveryAddress = defaultAddress,
                    onBack = { viewModel.closeCart() },
                    onIncrement = { item -> viewModel.incrementCartItem(item) },
                    onDecrement = { item -> viewModel.decrementCartItem(item) },
                    onDelete = { id -> viewModel.removeCartItem(id) },
                    onApplyCoupon = { coupon -> viewModel.applyCoupon(coupon) },
                    onRemoveCoupon = { viewModel.removeCoupon() },
                    onSetTip = { tip -> viewModel.setTipAmount(tip) },
                    onSetInstructions = { note -> viewModel.setCookingInstructions(note) },
                    onPlaceOrder = {
                        viewModel.placeOrder { orderId ->
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Order placed successfully! Tracking live...")
                            }
                        }
                    }
                )
            }

            // Restaurant Detail & Menu Sub-Screen
            selectedRestaurant != null -> {
                val restaurant = selectedRestaurant!!
                val isFav = favorites.any { it.restaurantId == restaurant.id }
                RestaurantDetailScreen(
                    restaurant = restaurant,
                    cartItems = cartItems,
                    isFavorite = isFav,
                    onBack = { viewModel.closeRestaurant() },
                    onFavoriteToggle = { viewModel.toggleFavorite(restaurant) },
                    onAddToCart = { dish -> viewModel.addDishToCart(dish, restaurant) },
                    onIncrement = { item -> viewModel.incrementCartItem(item) },
                    onDecrement = { item -> viewModel.decrementCartItem(item) }
                )
            }

            // Main Scaffold with Bottom Navigation
            else -> {
                Scaffold(
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    bottomBar = {
                        BottomNavBar(
                            currentTab = currentTab,
                            onTabSelected = { tab -> viewModel.selectTab(tab) },
                            cartItemCount = cartItemCount,
                            cartTotalAmount = cartTotalAmount,
                            onViewCartClick = { viewModel.openCart() }
                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        when (currentTab) {
                            MainTab.DELIVERY -> {
                                DeliveryHomeScreen(
                                    restaurants = filteredRestaurants,
                                    favorites = favorites,
                                    currentAddress = defaultAddress,
                                    searchQuery = searchQuery,
                                    onSearchChange = { viewModel.setSearchQuery(it) },
                                    selectedCuisine = selectedCuisine,
                                    onSelectCuisine = { viewModel.selectCuisine(it) },
                                    isVegOnly = isVegOnly,
                                    onToggleVeg = { viewModel.toggleVegOnly() },
                                    minRating = minRating,
                                    onToggleRating = { viewModel.setMinRating(4.0f) },
                                    fastDeliveryOnly = fastDeliveryOnly,
                                    onToggleFastDelivery = { viewModel.toggleFastDelivery() },
                                    onRestaurantClick = { rest -> viewModel.openRestaurant(rest) },
                                    onFavoriteToggle = { rest -> viewModel.toggleFavorite(rest) },
                                    onAddressClick = {
                                        if (activeUser != null) {
                                            viewModel.openEditProfileDialog()
                                        } else {
                                            viewModel.openAuthDialog(true)
                                        }
                                    },
                                    onProfileClick = { viewModel.selectTab(MainTab.ORDERS) },
                                    onResetFilters = { viewModel.resetFilters() }
                                )
                            }

                            MainTab.DINING -> {
                                DiningScreen(
                                    restaurants = filteredRestaurants,
                                    activeBookings = activeBookings,
                                    onBookTableClick = { rest -> viewModel.openTableBooking(rest) }
                                )
                            }

                            MainTab.GOLD -> {
                                GoldScreen()
                            }

                            MainTab.ORDERS -> {
                                ProfileOrdersScreen(
                                    user = activeUser,
                                    orders = orders,
                                    addresses = addresses,
                                    favorites = favorites,
                                    onOpenAuth = { isSignUp -> viewModel.openAuthDialog(isSignUp) },
                                    onEditProfile = { viewModel.openEditProfileDialog() },
                                    onLogout = { viewModel.logout() },
                                    onTrackOrder = { orderId -> viewModel.openOrderTracking(orderId) }
                                )
                            }
                        }
                    }
                }
            }
        }

        // Table Booking Dialog
        if (tableBookingRestaurant != null) {
            val restaurant = tableBookingRestaurant!!
            BookTableDialog(
                restaurant = restaurant,
                onDismiss = { viewModel.closeTableBooking() },
                onConfirm = { date, timeSlot, guests, request ->
                    viewModel.confirmTableBooking(restaurant, date, timeSlot, guests, request)
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Table reserved at ${restaurant.name} for $guests guests on $date at $timeSlot!")
                    }
                }
            )
        }

        // Auth Dialog (Sign Up / Sign In)
        if (showAuthDialog) {
            AuthDialog(
                initialIsSignUp = isSignUpMode,
                onDismiss = { viewModel.closeAuthDialog() },
                onSignUp = { name, email, pass, address, phone, onError ->
                    viewModel.signUp(name, email, pass, address, phone, onError)
                },
                onLogin = { email, pass, onError ->
                    viewModel.login(email, pass, onError)
                }
            )
        }

        // Edit Profile Dialog
        if (showEditProfileDialog && activeUser != null) {
            EditProfileDialog(
                user = activeUser!!,
                onDismiss = { viewModel.closeEditProfileDialog() },
                onSave = { name, address, phone ->
                    viewModel.updateProfile(name, address, phone)
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Profile & delivery address updated!")
                    }
                }
            )
        }
    }
}
