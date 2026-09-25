package com.example.data.model

data class Restaurant(
    val id: String,
    val name: String,
    val cuisines: List<String>,
    val rating: Float,
    val totalRatingsCount: String,
    val deliveryTimeMin: Int,
    val deliveryTimeMax: Int,
    val distanceKm: Float,
    val costForTwo: Double,
    val priceRange: String = "$$",
    val description: String = "",
    val offerText: String,
    val isPureVeg: Boolean = false,
    val isGoldPartner: Boolean = true,
    val isPromoted: Boolean = false,
    val diningAvailable: Boolean = true,
    val diningDiscount: String? = "Flat 25% OFF with Gold",
    val bannerDrawableRes: Int? = null,
    val address: String = "Indiranagar, 100ft Road",
    val menuCategories: List<MenuCategory> = emptyList()
)

data class MenuCategory(
    val id: String,
    val name: String,
    val dishes: List<Dish>
)

data class Dish(
    val id: String,
    val restaurantId: String,
    val name: String,
    val description: String,
    val price: Double,
    val isVeg: Boolean,
    val isEgg: Boolean = false,
    val isBestseller: Boolean = false,
    val rating: Float = 4.5f,
    val ratingCount: Int = 85,
    val isCustomizable: Boolean = false,
    val categoryName: String = "Main Course"
)

enum class OrderStatus(val label: String, val stepIndex: Int) {
    CONFIRMED("Order Confirmed", 0),
    PREPARING("Kitchen Preparing Food", 1),
    OUT_FOR_DELIVERY("Valet On The Way", 2),
    DELIVERED("Delivered", 3),
    CANCELLED("Cancelled", -1)
}

data class OrderRecord(
    val orderId: String,
    val restaurantName: String,
    val restaurantId: String,
    val itemsSummary: String,
    val totalAmount: Double,
    val orderTimeMillis: Long,
    val status: OrderStatus,
    val deliveryPartnerName: String = "Rajesh Kumar",
    val deliveryPartnerPhone: String = "+1 (555) 234-8899",
    val vehicleNumber: String = "KA 03 EQ 4821",
    val estimatedMinutes: Int = 24,
    val deliveryAddress: String = "104, Green Glen Heights, Bellandur, Bengaluru"
)

data class TableBooking(
    val bookingId: String,
    val restaurantName: String,
    val restaurantAddress: String,
    val date: String,
    val timeSlot: String,
    val guestsCount: Int,
    val specialRequest: String,
    val discount: String = "Flat 25% OFF with Gold"
)

data class Coupon(
    val code: String,
    val description: String,
    val discountPercent: Int,
    val maxDiscount: Double,
    val minOrderAmount: Double
)
