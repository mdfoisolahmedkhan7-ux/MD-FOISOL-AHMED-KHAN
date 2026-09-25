package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Dining
import androidx.compose.material.icons.filled.DeliveryDining
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material.icons.outlined.Dining
import androidx.compose.material.icons.outlined.DeliveryDining
import androidx.compose.material.icons.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.WorkspacePremium
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.Gray200
import com.example.ui.theme.Gray400
import com.example.ui.theme.Gray900
import com.example.ui.theme.ZomatoGold
import com.example.ui.theme.ZomatoRed
import com.example.ui.viewmodel.MainTab

@Composable
fun BottomNavBar(
    currentTab: MainTab,
    onTabSelected: (MainTab) -> Unit,
    cartItemCount: Int,
    cartTotalAmount: Double,
    onViewCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        // Floating Cart Bar (Appears when items are in cart)
        AnimatedVisibility(
            visible = cartItemCount > 0,
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it })
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable(onClick = onViewCartClick)
                    .testTag("floating_cart_bar"),
                color = ZomatoRed,
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "$cartItemCount ${if (cartItemCount == 1) "ITEM" else "ITEMS"} ADDED",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White.copy(alpha = 0.85f),
                            letterSpacing = 0.5.sp
                        )
                        Text(
                            text = "$${String.format("%.2f", cartTotalAmount)}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "View Cart",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "View Cart",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }

        HorizontalDivider(thickness = 0.6.dp, color = Gray200)

        // Main Navigation Bar
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            modifier = Modifier.height(64.dp)
        ) {
            // Delivery Tab
            NavigationBarItem(
                selected = currentTab == MainTab.DELIVERY,
                onClick = { onTabSelected(MainTab.DELIVERY) },
                icon = {
                    Icon(
                        imageVector = if (currentTab == MainTab.DELIVERY) Icons.Filled.DeliveryDining else Icons.Outlined.DeliveryDining,
                        contentDescription = "Delivery"
                    )
                },
                label = { Text("Delivery", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ZomatoRed,
                    selectedTextColor = ZomatoRed,
                    indicatorColor = ZomatoRed.copy(alpha = 0.12f),
                    unselectedIconColor = Gray400,
                    unselectedTextColor = Gray400
                ),
                modifier = Modifier.testTag("nav_tab_delivery")
            )

            // Dining Tab
            NavigationBarItem(
                selected = currentTab == MainTab.DINING,
                onClick = { onTabSelected(MainTab.DINING) },
                icon = {
                    Icon(
                        imageVector = if (currentTab == MainTab.DINING) Icons.Filled.Dining else Icons.Outlined.Dining,
                        contentDescription = "Dining"
                    )
                },
                label = { Text("Dining", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ZomatoRed,
                    selectedTextColor = ZomatoRed,
                    indicatorColor = ZomatoRed.copy(alpha = 0.12f),
                    unselectedIconColor = Gray400,
                    unselectedTextColor = Gray400
                ),
                modifier = Modifier.testTag("nav_tab_dining")
            )

            // Gold Tab
            NavigationBarItem(
                selected = currentTab == MainTab.GOLD,
                onClick = { onTabSelected(MainTab.GOLD) },
                icon = {
                    Icon(
                        imageVector = if (currentTab == MainTab.GOLD) Icons.Filled.WorkspacePremium else Icons.Outlined.WorkspacePremium,
                        contentDescription = "Gold VIP"
                    )
                },
                label = { Text("Gold VIP", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ZomatoGold,
                    selectedTextColor = ZomatoGold,
                    indicatorColor = ZomatoGold.copy(alpha = 0.15f),
                    unselectedIconColor = Gray400,
                    unselectedTextColor = Gray400
                ),
                modifier = Modifier.testTag("nav_tab_gold")
            )

            // Orders Tab
            NavigationBarItem(
                selected = currentTab == MainTab.ORDERS,
                onClick = { onTabSelected(MainTab.ORDERS) },
                icon = {
                    Icon(
                        imageVector = if (currentTab == MainTab.ORDERS) Icons.Filled.ReceiptLong else Icons.Outlined.ReceiptLong,
                        contentDescription = "Orders"
                    )
                },
                label = { Text("Orders", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ZomatoRed,
                    selectedTextColor = ZomatoRed,
                    indicatorColor = ZomatoRed.copy(alpha = 0.12f),
                    unselectedIconColor = Gray400,
                    unselectedTextColor = Gray400
                ),
                modifier = Modifier.testTag("nav_tab_orders")
            )
        }
    }
}
