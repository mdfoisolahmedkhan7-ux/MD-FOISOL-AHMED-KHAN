package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DeliveryDining
import androidx.compose.material.icons.filled.FastForward
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.OrderEntity
import com.example.data.model.OrderStatus
import com.example.ui.components.LiveDeliveryMap
import com.example.ui.theme.Gray100
import com.example.ui.theme.Gray200
import com.example.ui.theme.Gray300
import com.example.ui.theme.Gray400
import com.example.ui.theme.Gray500
import com.example.ui.theme.Gray700
import com.example.ui.theme.RatingGreen
import com.example.ui.theme.StarGold
import com.example.ui.theme.ZomatoGoldLight
import com.example.ui.theme.ZomatoRed
import com.example.ui.theme.ZomatoRedLight

@Composable
fun OrderTrackingScreen(
    order: OrderEntity?,
    onBack: () -> Unit,
    onAdvanceStatus: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler { onBack() }

    val currentStatus = try {
        OrderStatus.valueOf(order?.status ?: OrderStatus.CONFIRMED.name)
    } catch (e: Exception) {
        OrderStatus.CONFIRMED
    }

    val stepProgress = when (currentStatus) {
        OrderStatus.CONFIRMED -> 0.15f
        OrderStatus.PREPARING -> 0.40f
        OrderStatus.OUT_FOR_DELIVERY -> 0.75f
        OrderStatus.DELIVERED -> 1.0f
        else -> 0.0f
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top App Bar
        Surface(
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 2.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack, modifier = Modifier.testTag("tracking_back_btn")) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Column {
                    Text(
                        text = "Live Order Tracking",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Order #${order?.orderId ?: "---"}",
                        fontSize = 12.sp,
                        color = Gray500
                    )
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .testTag("tracking_content_list"),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Live Simulation Canvas Map
            item {
                LiveDeliveryMap(
                    restaurantName = order?.restaurantName ?: "Restaurant",
                    stepProgress = stepProgress
                )
            }

            // ETA Status Header Card
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = if (currentStatus == OrderStatus.DELIVERED) "Order Delivered!" else "Arriving in 18-22 mins",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Black,
                                    color = if (currentStatus == OrderStatus.DELIVERED) RatingGreen else ZomatoRed
                                )
                                Text(
                                    text = when (currentStatus) {
                                        OrderStatus.CONFIRMED -> "Order received by ${order?.restaurantName}"
                                        OrderStatus.PREPARING -> "Chef is preparing your meal"
                                        OrderStatus.OUT_FOR_DELIVERY -> "Valet picked up your food and is speeding over"
                                        OrderStatus.DELIVERED -> "Enjoy your meal! Rate your experience below"
                                        else -> ""
                                    },
                                    fontSize = 12.sp,
                                    color = Gray500
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = if (currentStatus == OrderStatus.DELIVERED) RatingGreen else ZomatoRed
                            ) {
                                Text(
                                    text = currentStatus.label,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        // Progress Stepper
                        val steps = listOf(
                            "Confirmed",
                            "Preparing",
                            "On The Way",
                            "Delivered"
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            steps.forEachIndexed { index, title ->
                                val isDone = index <= currentStatus.stepIndex
                                val isCurrent = index == currentStatus.stepIndex

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Box(
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clip(CircleShape)
                                            .background(if (isDone) RatingGreen else Gray200),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (isDone) {
                                            Icon(
                                                imageVector = Icons.Filled.Check,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(16.dp)
                                            )
                                        } else {
                                            Text(
                                                text = "${index + 1}",
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Gray500
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = title,
                                        fontSize = 10.sp,
                                        fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isDone) MaterialTheme.colorScheme.onSurface else Gray400
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Delivery Partner Card
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(ZomatoRedLight),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.DeliveryDining,
                                contentDescription = null,
                                tint = ZomatoRed,
                                modifier = Modifier.size(28.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "Rajesh Kumar",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = RatingGreen
                                ) {
                                    Text(
                                        text = "4.9 ★",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Hero Splendor • KA 03 EQ 4821",
                                fontSize = 12.sp,
                                color = Gray500
                            )
                        }

                        Row {
                            IconButton(
                                onClick = {},
                                modifier = Modifier
                                    .size(38.dp)
                                    .background(Gray100, CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Call,
                                    contentDescription = "Call Driver",
                                    tint = ZomatoRed,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            IconButton(
                                onClick = {},
                                modifier = Modifier
                                    .size(38.dp)
                                    .background(Gray100, CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Message,
                                    contentDescription = "Message Driver",
                                    tint = Gray700,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Order Receipt Summary Card
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "ORDER DETAILS",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Gray700,
                            letterSpacing = 1.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = order?.restaurantName ?: "Restaurant",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = order?.itemsSummary ?: "",
                            fontSize = 13.sp,
                            color = Gray700
                        )

                        HorizontalDivider(
                            thickness = 0.5.dp,
                            color = Gray200,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Total Paid", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text(
                                text = "$${String.format("%.2f", order?.totalAmount ?: 0.0)}",
                                fontWeight = FontWeight.Black,
                                fontSize = 15.sp,
                                color = ZomatoRed
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Delivered to: ${order?.deliveryAddress ?: ""}",
                            fontSize = 11.sp,
                            color = Gray500
                        )
                    }
                }
            }

            // Demo Simulation Button (to immediately test state advancement)
            if (order != null && currentStatus != OrderStatus.DELIVERED) {
                item {
                    Button(
                        onClick = { onAdvanceStatus(order.orderId) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("simulate_next_status_btn"),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF263238)),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.FastForward,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Fast-Forward Delivery Status (Demo)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
    }
}
