package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DeliveryDining
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.AddressEntity
import com.example.data.local.FavoriteEntity
import com.example.data.local.OrderEntity
import com.example.data.local.UserProfileEntity
import com.example.data.model.OrderStatus
import com.example.ui.theme.Gray100
import com.example.ui.theme.Gray200
import com.example.ui.theme.Gray300
import com.example.ui.theme.Gray400
import com.example.ui.theme.Gray500
import com.example.ui.theme.Gray700
import com.example.ui.theme.Gray800
import com.example.ui.theme.RatingGreen
import com.example.ui.theme.ZomatoGold
import com.example.ui.theme.ZomatoGoldLight
import com.example.ui.theme.ZomatoRed
import com.example.ui.theme.ZomatoRedLight
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ProfileOrdersScreen(
    user: UserProfileEntity?,
    orders: List<OrderEntity>,
    addresses: List<AddressEntity>,
    favorites: List<FavoriteEntity>,
    onOpenAuth: (isSignUp: Boolean) -> Unit,
    onEditProfile: () -> Unit,
    onLogout: () -> Unit,
    onTrackOrder: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val dateFormatter = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .testTag("profile_orders_screen"),
        contentPadding = PaddingValues(bottom = 90.dp)
    ) {
        // User Profile Header
        item {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 2.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(18.dp)
                ) {
                    if (user != null && user.isLoggedIn) {
                        // Logged-in User Profile Card
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(ZomatoRedLight),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = null,
                                    tint = ZomatoRed,
                                    modifier = Modifier.size(32.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(14.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = user.fullName,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Black
                                )
                                Text(
                                    text = user.email,
                                    fontSize = 12.sp,
                                    color = Gray500
                                )
                                if (user.phone.isNotBlank()) {
                                    Text(
                                        text = user.phone,
                                        fontSize = 11.sp,
                                        color = Gray500
                                    )
                                }
                            }

                            // Edit Profile Icon
                            OutlinedButton(
                                onClick = onEditProfile,
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.testTag("edit_profile_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Edit,
                                    contentDescription = "Edit Profile",
                                    modifier = Modifier.size(14.dp),
                                    tint = ZomatoRed
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Edit", fontSize = 11.sp, color = ZomatoRed, fontWeight = FontWeight.Bold)
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Default Delivery Address Banner
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = Gray100,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = null,
                                    tint = ZomatoRed,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "Primary Delivery Address",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Gray700
                                    )
                                    Text(
                                        text = user.deliveryAddress,
                                        fontSize = 12.sp,
                                        color = Gray800
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Log Out / Switch Account Action
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = "Log Out",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = ZomatoRed,
                                modifier = Modifier
                                    .clickable(onClick = onLogout)
                                    .padding(vertical = 4.dp, horizontal = 8.dp)
                                    .testTag("logout_btn")
                            )
                        }
                    } else {
                        // Guest / Not logged in card
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Welcome to Zomato",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Black
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Sign up or sign in to manage your addresses and view past orders",
                                fontSize = 12.sp,
                                color = Gray500,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Button(
                                    onClick = { onOpenAuth(true) },
                                    colors = ButtonDefaults.buttonColors(containerColor = ZomatoRed),
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.testTag("profile_signup_btn")
                                ) {
                                    Text("Sign Up with Email", fontWeight = FontWeight.Bold)
                                }
                                OutlinedButton(
                                    onClick = { onOpenAuth(false) },
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.testTag("profile_signin_btn")
                                ) {
                                    Text("Sign In")
                                }
                            }
                        }
                    }
                }
            }
        }

        // Section: Past Orders History
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "PAST ORDERS HISTORY",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Gray700,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "${orders.size} orders",
                    fontSize = 12.sp,
                    color = Gray500
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        if (orders.isEmpty()) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(28.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.History,
                            contentDescription = null,
                            tint = Gray300,
                            modifier = Modifier.size(44.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "No orders placed yet",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "When you order food, your restaurant name, items, total cost, and date will be displayed here.",
                            fontSize = 12.sp,
                            color = Gray500,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }
            }
        } else {
            items(orders, key = { it.orderId }) { order ->
                val formattedDate = dateFormatter.format(Date(order.orderTimeMillis))
                val isDelivered = order.status == OrderStatus.DELIVERED.name

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                        .clickable { onTrackOrder(order.orderId) }
                        .testTag("order_item_${order.orderId}"),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        // Top Header: Restaurant Name & Order Status
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = order.restaurantName,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                // Date of Order
                                Text(
                                    text = "Ordered on: $formattedDate",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Gray500
                                )
                            }

                            // Status Tag
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (isDelivered) RatingGreen.copy(alpha = 0.12f) else ZomatoRedLight
                            ) {
                                Text(
                                    text = order.status.replace("_", " "),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDelivered) RatingGreen else ZomatoRed,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Items Ordered
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Gray100,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = "ITEMS ORDERED",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Gray500,
                                    letterSpacing = 0.5.sp
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = order.itemsSummary,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                        HorizontalDivider(
                            thickness = 0.6.dp,
                            color = Gray200,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )

                        // Bottom Row: Total Cost & Action
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "TOTAL COST",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Gray500
                                )
                                Text(
                                    text = "$${String.format("%.2f", order.totalAmount)}",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 16.sp,
                                    color = ZomatoRed
                                )
                            }

                            OutlinedButton(
                                onClick = { onTrackOrder(order.orderId) },
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.testTag("track_order_btn_${order.orderId}")
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.DeliveryDining,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = ZomatoRed
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (isDelivered) "Order Summary" else "Track Live ➔",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = ZomatoRed
                                )
                            }
                        }
                    }
                }
            }
        }

        // Section: Saved Delivery Addresses
        item {
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "SAVED DELIVERY ADDRESSES",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Gray700,
                letterSpacing = 1.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            addresses.forEach { addr ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = null,
                            tint = ZomatoRed,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = addr.tag,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                                if (addr.isDefault) {
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = Gray100
                                    ) {
                                        Text(
                                            text = "PRIMARY",
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Gray700,
                                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }
                            Text(
                                text = "${addr.fullAddress}, ${addr.landmark}",
                                fontSize = 12.sp,
                                color = Gray500
                            )
                        }
                    }
                }
            }
        }
    }
}
