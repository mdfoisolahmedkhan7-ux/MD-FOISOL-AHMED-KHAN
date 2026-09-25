package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserProfileEntity(
    @PrimaryKey
    val email: String,
    val fullName: String,
    val passwordHash: String,
    val deliveryAddress: String,
    val phone: String = "+1 (555) 019-2831",
    val isLoggedIn: Boolean = true,
    val createdAtMillis: Long = System.currentTimeMillis()
)

@Entity(tableName = "cart_items")
data class CartItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val restaurantId: String,
    val restaurantName: String,
    val dishId: String,
    val dishName: String,
    val price: Double,
    val quantity: Int,
    val isVeg: Boolean,
    val customizationNote: String = ""
)

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey
    val orderId: String,
    val userEmail: String = "aarav@example.com",
    val restaurantName: String,
    val restaurantId: String,
    val itemsSummary: String,
    val totalAmount: Double,
    val orderTimeMillis: Long,
    val status: String,
    val deliveryAddress: String,
    val estimatedMinutes: Int
)

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey
    val restaurantId: String,
    val restaurantName: String
)

@Entity(tableName = "saved_addresses")
data class AddressEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val tag: String, // "Home", "Work", "Other"
    val fullAddress: String,
    val landmark: String,
    val isDefault: Boolean = false
)
