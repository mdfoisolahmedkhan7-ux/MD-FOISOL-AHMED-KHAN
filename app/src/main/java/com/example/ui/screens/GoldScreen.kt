package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.theme.Gray200
import com.example.ui.theme.Gray400
import com.example.ui.theme.Gray500
import com.example.ui.theme.Gray700
import com.example.ui.theme.RatingGreen
import com.example.ui.theme.ZomatoGold
import com.example.ui.theme.ZomatoGoldDark
import com.example.ui.theme.ZomatoGoldLight
import com.example.ui.theme.ZomatoRed

@Composable
fun GoldScreen(
    modifier: Modifier = Modifier
) {
    var isGoldActive by remember { mutableStateOf(true) }
    var selectedPlanIndex by remember { mutableIntStateOf(1) } // 12-month best value

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .testTag("gold_vip_screen"),
        contentPadding = PaddingValues(bottom = 90.dp)
    ) {
        // VIP Banner
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_gold_perk),
                    contentDescription = "Zomato Gold VIP",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.85f))
                            )
                        )
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(18.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.WorkspacePremium,
                            contentDescription = null,
                            tint = ZomatoGold,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "ZOMATO GOLD",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            color = ZomatoGold,
                            letterSpacing = 1.sp
                        )
                    }
                    Text(
                        text = "VIP Dining & Delivery Privileges",
                        fontSize = 13.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        }

        // Active Membership Status Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isGoldActive) Color(0xFF1E1E24) else MaterialTheme.colorScheme.surface
                ),
                border = androidx.compose.foundation.BorderStroke(1.2.dp, ZomatoGold)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape)
                                    .background(ZomatoGold.copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.WorkspacePremium,
                                    contentDescription = null,
                                    tint = ZomatoGold,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = if (isGoldActive) "VIP Gold Member" else "Gold Inactive",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isGoldActive) Color.White else MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = if (isGoldActive) "Valid until Dec 2026" else "Join to unlock VIP perks",
                                    fontSize = 12.sp,
                                    color = if (isGoldActive) ZomatoGold else Gray500
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (isGoldActive) RatingGreen else ZomatoGold
                        ) {
                            Text(
                                text = if (isGoldActive) "ACTIVE" else "JOIN NOW",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Savings Metric
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = if (isGoldActive) Color(0xFF2B2B36) else Gray200,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "$64.80",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Black,
                                    color = ZomatoGold
                                )
                                Text(
                                    text = "Total Saved",
                                    fontSize = 11.sp,
                                    color = if (isGoldActive) Color.White.copy(alpha = 0.7f) else Gray700
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "14",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Black,
                                    color = if (isGoldActive) Color.White else MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Free Deliveries",
                                    fontSize = 11.sp,
                                    color = if (isGoldActive) Color.White.copy(alpha = 0.7f) else Gray700
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "6",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Black,
                                    color = if (isGoldActive) Color.White else MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Dine-in Discounts",
                                    fontSize = 11.sp,
                                    color = if (isGoldActive) Color.White.copy(alpha = 0.7f) else Gray700
                                )
                            }
                        }
                    }
                }
            }
        }

        // Perks List
        item {
            Text(
                text = "GOLD PRIVILEGES",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Gray700,
                letterSpacing = 1.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            val perks = listOf(
                Triple(
                    Icons.Filled.ElectricBolt,
                    "Unlimited Free Deliveries",
                    "No delivery fee on all food orders above $12 within 10km radius"
                ),
                Triple(
                    Icons.Filled.Restaurant,
                    "Up to 40% Off on Dining Out",
                    "Valid across 20,000+ premium dine-in restaurants with no upper cap"
                ),
                Triple(
                    Icons.Filled.Diamond,
                    "VIP Priority Delivery",
                    "Your orders jump the queue during peak meal rush hours"
                ),
                Triple(
                    Icons.Filled.SupportAgent,
                    "24/7 Dedicated VIP Support",
                    "Direct 1-tap call line with specialized senior support agents"
                )
            )

            perks.forEach { (icon, title, desc) ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(ZomatoGoldLight),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = ZomatoGoldDark,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = title,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = desc,
                                fontSize = 12.sp,
                                color = Gray500
                            )
                        }
                    }
                }
            }
        }

        // Plan Selection
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "CHOOSE YOUR PLAN",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Gray700,
                letterSpacing = 1.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // 3 months
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedPlanIndex = 0 },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectedPlanIndex == 0) ZomatoGoldLight else MaterialTheme.colorScheme.surface
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = if (selectedPlanIndex == 0) 2.dp else 1.dp,
                        color = if (selectedPlanIndex == 0) ZomatoGold else Gray200
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "3 Months", fontSize = 13.sp, fontWeight = FontWeight.Medium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "$9.99", fontSize = 18.sp, fontWeight = FontWeight.Black)
                        Text(text = "$3.33/mo", fontSize = 11.sp, color = Gray500)
                    }
                }

                // 12 months (Best value)
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedPlanIndex = 1 },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectedPlanIndex == 1) ZomatoGoldLight else MaterialTheme.colorScheme.surface
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = if (selectedPlanIndex == 1) 2.dp else 1.dp,
                        color = if (selectedPlanIndex == 1) ZomatoGold else Gray200
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = ZomatoGold
                        ) {
                            Text(
                                text = "BEST VALUE",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "12 Months", fontSize = 13.sp, fontWeight = FontWeight.Medium)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = "$29.99", fontSize = 18.sp, fontWeight = FontWeight.Black)
                        Text(text = "$2.50/mo", fontSize = 11.sp, color = Gray500)
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Button(
                onClick = { isGoldActive = !isGoldActive },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 16.dp)
                    .testTag("toggle_gold_membership_btn"),
                colors = ButtonDefaults.buttonColors(containerColor = ZomatoGold),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = if (isGoldActive) "Gold Active • Manage Plan" else "Activate Zomato Gold Now",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.Black
                )
            }
        }
    }
}
