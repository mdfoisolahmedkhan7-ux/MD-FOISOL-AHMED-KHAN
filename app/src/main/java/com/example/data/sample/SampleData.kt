package com.example.data.sample

import com.example.data.model.Coupon
import com.example.data.model.Restaurant

object SampleData {

    val coupons = listOf(
        Coupon(
            code = "ZOMATO50",
            description = "50% OFF up to $8 on orders above $15",
            discountPercent = 50,
            maxDiscount = 8.0,
            minOrderAmount = 15.0
        ),
        Coupon(
            code = "GOLDFREE",
            description = "100% OFF on delivery fee + extra $3 off",
            discountPercent = 20,
            maxDiscount = 5.0,
            minOrderAmount = 10.0
        ),
        Coupon(
            code = "TASTYDEAL",
            description = "Flat $4 OFF on gourmet feast orders over $20",
            discountPercent = 15,
            maxDiscount = 4.0,
            minOrderAmount = 20.0
        )
    )

    val cuisinesList = listOf(
        "All",
        "Italian",
        "Indian",
        "Japanese",
        "Mexican",
        "American",
        "Chinese",
        "Thai",
        "Seafood",
        "Healthy",
        "Desserts"
    )

    val restaurants: List<Restaurant> =
        FictionalRestaurantsPart1.restaurants + FictionalRestaurantsPart2.restaurants
}
