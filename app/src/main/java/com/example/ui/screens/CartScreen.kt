package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.DeliveryDining
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.AddressEntity
import com.example.data.local.CartItemEntity
import com.example.data.model.Coupon
import com.example.data.sample.SampleData
import com.example.ui.components.VegNonVegBadge
import com.example.ui.theme.Gray100
import com.example.ui.theme.Gray200
import com.example.ui.theme.Gray300
import com.example.ui.theme.Gray500
import com.example.ui.theme.Gray700
import com.example.ui.theme.Gray900
import com.example.ui.theme.RatingGreen
import com.example.ui.theme.ZomatoGold
import com.example.ui.theme.ZomatoRed
import com.example.ui.theme.ZomatoRedLight

@Composable
fun CartScreen(
    cartItems: List<CartItemEntity>,
    appliedCoupon: Coupon?,
    tipAmount: Double,
    cookingInstructions: String,
    deliveryAddress: String,
    onBack: () -> Unit,
    onIncrement: (CartItemEntity) -> Unit,
    onDecrement: (CartItemEntity) -> Unit,
    onDelete: (Int) -> Unit,
    onApplyCoupon: (Coupon) -> Unit,
    onRemoveCoupon: () -> Unit,
    onSetTip: (Double) -> Unit,
    onSetInstructions: (String) -> Unit,
    onPlaceOrder: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler { onBack() }

    var selectedPaymentMethod by remember { mutableStateOf("UPI / Google Pay") }

    val itemTotal = cartItems.sumOf { it.price * it.quantity }
    val baseDeliveryFee = 2.50
    val deliveryFee = if (appliedCoupon?.code == "GOLDFREE") 0.0 else baseDeliveryFee
    val platformFee = 0.50
    val taxes = itemTotal * 0.08
    val discount = appliedCoupon?.let {
        (itemTotal * (it.discountPercent / 100.0)).coerceAtMost(it.maxDiscount)
    } ?: 0.0
    val grandTotal = (itemTotal + deliveryFee + platformFee + taxes + tipAmount - discount).coerceAtLeast(0.0)

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
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack, modifier = Modifier.testTag("cart_back_btn")) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Column {
                    Text(
                        text = if (cartItems.isNotEmpty()) cartItems.first().restaurantName else "Your Cart",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    if (cartItems.isNotEmpty()) {
                        Text(
                            text = "Delivering in 25-30 mins",
                            fontSize = 12.sp,
                            color = Gray500
                        )
                    }
                }
            }
        }

        if (cartItems.isEmpty()) {
            // Empty Cart State
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingBag,
                    contentDescription = null,
                    tint = Gray300,
                    modifier = Modifier.size(72.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Good food is always cooking",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Your cart is empty. Add something delicious from our restaurants!",
                    fontSize = 13.sp,
                    color = Gray500,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(containerColor = ZomatoRed),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Browse Restaurants")
                }
            }
        } else {
            // Cart Items and Bill Content
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .testTag("cart_items_list"),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Items List Card
                item {
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "ORDER ITEMS",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Gray700,
                                letterSpacing = 1.sp
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            cartItems.forEachIndexed { index, item ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        VegNonVegBadge(isVeg = item.isVeg)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Column {
                                            Text(
                                                text = item.dishName,
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 14.sp
                                            )
                                            Text(
                                                text = "$${String.format("%.2f", item.price)}",
                                                fontSize = 12.sp,
                                                color = Gray500
                                            )
                                        }
                                    }

                                    // Stepper
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        border = androidx.compose.foundation.BorderStroke(1.dp, ZomatoRed),
                                        color = ZomatoRedLight,
                                        modifier = Modifier.width(88.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(vertical = 4.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .clickable { onDecrement(item) },
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Filled.Remove,
                                                    contentDescription = "Decrease",
                                                    tint = ZomatoRed,
                                                    modifier = Modifier.size(14.dp)
                                                )
                                            }
                                            Text(
                                                text = "${item.quantity}",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = ZomatoRed
                                            )
                                            Box(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .clickable { onIncrement(item) },
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Filled.Add,
                                                    contentDescription = "Increase",
                                                    tint = ZomatoRed,
                                                    modifier = Modifier.size(14.dp)
                                                )
                                            }
                                        }
                                    }

                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        text = "$${String.format("%.2f", item.price * item.quantity)}",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }

                                if (index < cartItems.size - 1) {
                                    HorizontalDivider(thickness = 0.5.dp, color = Gray200)
                                }
                            }
                        }
                    }
                }

                // Cooking Instructions Card
                item {
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "COOKING & DELIVERY INSTRUCTIONS",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Gray700,
                                letterSpacing = 1.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            OutlinedTextField(
                                value = cookingInstructions,
                                onValueChange = onSetInstructions,
                                placeholder = {
                                    Text(
                                        "e.g. Leave at door, don't ring bell, extra spicy, no cutlery...",
                                        fontSize = 12.sp,
                                        color = Gray500
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("cooking_instructions_input"),
                                shape = RoundedCornerShape(8.dp),
                                maxLines = 2,
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = ZomatoRed,
                                    unfocusedBorderColor = Gray300
                                )
                            )
                        }
                    }
                }

                // Coupons Section Card
                item {
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Outlined.LocalOffer,
                                        contentDescription = null,
                                        tint = ZomatoRed,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "COUPONS & OFFERS",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Gray700
                                    )
                                }
                                if (appliedCoupon != null) {
                                    Text(
                                        text = "Remove",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = ZomatoRed,
                                        modifier = Modifier
                                            .clickable(onClick = onRemoveCoupon)
                                            .testTag("remove_coupon_btn")
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            SampleData.coupons.forEach { coupon ->
                                val isApplied = appliedCoupon?.code == coupon.code
                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    shape = RoundedCornerShape(8.dp),
                                    color = if (isApplied) ZomatoRedLight else Gray100,
                                    border = androidx.compose.foundation.BorderStroke(
                                        1.dp,
                                        if (isApplied) ZomatoRed else Color.Transparent
                                    )
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = coupon.code,
                                                fontWeight = FontWeight.ExtraBold,
                                                fontSize = 13.sp,
                                                color = if (isApplied) ZomatoRed else Gray900
                                            )
                                            Text(
                                                text = coupon.description,
                                                fontSize = 11.sp,
                                                color = Gray500
                                            )
                                        }
                                        if (isApplied) {
                                            Surface(
                                                shape = RoundedCornerShape(4.dp),
                                                color = RatingGreen
                                            ) {
                                                Text(
                                                    text = "APPLIED",
                                                    color = Color.White,
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                )
                                            }
                                        } else {
                                            Text(
                                                text = "APPLY",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 12.sp,
                                                color = ZomatoRed,
                                                modifier = Modifier
                                                    .clickable { onApplyCoupon(coupon) }
                                                    .testTag("apply_coupon_${coupon.code}")
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Delivery Partner Tip
                item {
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Outlined.DeliveryDining,
                                    contentDescription = null,
                                    tint = ZomatoRed,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Column {
                                    Text(
                                        text = "TIP YOUR DELIVERY VALET",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Gray700
                                    )
                                    Text(
                                        text = "100% of tip goes directly to your partner",
                                        fontSize = 11.sp,
                                        color = Gray500
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            val tips = listOf(0.0, 1.0, 2.0, 3.0, 5.0)
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                tips.forEach { tip ->
                                    val isSelected = tipAmount == tip
                                    Surface(
                                        modifier = Modifier
                                            .weight(1f)
                                            .clickable { onSetTip(tip) }
                                            .testTag("tip_btn_${tip.toInt()}"),
                                        shape = RoundedCornerShape(8.dp),
                                        color = if (isSelected) ZomatoRed else Gray100,
                                        border = androidx.compose.foundation.BorderStroke(
                                            1.dp,
                                            if (isSelected) ZomatoRed else Gray300
                                        )
                                    ) {
                                        Text(
                                            text = if (tip == 0.0) "None" else "$${tip.toInt()}",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.padding(vertical = 8.dp),
                                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Bill Details Breakdown Card
                item {
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "BILL SUMMARY",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Gray700,
                                letterSpacing = 1.sp
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "Item Total", fontSize = 13.sp, color = Gray700)
                                Text(text = "$${String.format("%.2f", itemTotal)}", fontSize = 13.sp)
                            }

                            Spacer(modifier = Modifier.height(6.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "Delivery Partner Fee", fontSize = 13.sp, color = Gray700)
                                if (deliveryFee == 0.0) {
                                    Row {
                                        Text(
                                            text = "$2.50",
                                            fontSize = 12.sp,
                                            color = Gray500,
                                            textDecoration = TextDecoration.LineThrough
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(text = "FREE", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = RatingGreen)
                                    }
                                } else {
                                    Text(text = "$${String.format("%.2f", deliveryFee)}", fontSize = 13.sp)
                                }
                            }

                            Spacer(modifier = Modifier.height(6.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "Platform Fee", fontSize = 13.sp, color = Gray700)
                                Text(text = "$${String.format("%.2f", platformFee)}", fontSize = 13.sp)
                            }

                            Spacer(modifier = Modifier.height(6.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "GST & Restaurant Taxes (8%)", fontSize = 13.sp, color = Gray700)
                                Text(text = "$${String.format("%.2f", taxes)}", fontSize = 13.sp)
                            }

                            if (tipAmount > 0) {
                                Spacer(modifier = Modifier.height(6.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "Delivery Partner Tip", fontSize = 13.sp, color = Gray700)
                                    Text(text = "$${String.format("%.2f", tipAmount)}", fontSize = 13.sp)
                                }
                            }

                            if (discount > 0) {
                                Spacer(modifier = Modifier.height(6.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Coupon Discount (${appliedCoupon?.code})",
                                        fontSize = 13.sp,
                                        color = RatingGreen,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "-$${String.format("%.2f", discount)}",
                                        fontSize = 13.sp,
                                        color = RatingGreen,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }

                            HorizontalDivider(
                                thickness = 0.8.dp,
                                color = Gray200,
                                modifier = Modifier.padding(vertical = 10.dp)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Grand Total",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Black
                                )
                                Text(
                                    text = "$${String.format("%.2f", grandTotal)}",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Black,
                                    color = ZomatoRed
                                )
                            }
                        }
                    }
                }

                // Payment Method Selector
                item {
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "PAYMENT METHOD",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Gray700,
                                letterSpacing = 1.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            val methods = listOf("UPI / Google Pay", "Credit / Debit Card", "Cash on Delivery")
                            methods.forEach { method ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { selectedPaymentMethod = method }
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = selectedPaymentMethod == method,
                                        onClick = { selectedPaymentMethod = method },
                                        colors = RadioButtonDefaults.colors(selectedColor = ZomatoRed)
                                    )
                                    Text(
                                        text = method,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Bottom Fixed Checkout Action Bar
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars),
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // Delivery Address Strip
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = null,
                            tint = ZomatoRed,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Delivering to $deliveryAddress",
                            fontSize = 12.sp,
                            color = Gray700,
                            maxLines = 1,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = onPlaceOrder,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .testTag("place_order_btn"),
                        colors = ButtonDefaults.buttonColors(containerColor = ZomatoRed),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "$${String.format("%.2f", grandTotal)}  |  Total",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "PLACE ORDER ➔",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black
                            )
                        }
                    }
                }
            }
        }
    }
}
