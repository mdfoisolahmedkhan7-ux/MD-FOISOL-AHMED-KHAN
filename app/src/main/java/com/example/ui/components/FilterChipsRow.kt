package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ElectricBolt
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.example.data.sample.SampleData
import com.example.ui.theme.Gray100
import com.example.ui.theme.Gray300
import com.example.ui.theme.Gray700
import com.example.ui.theme.Gray800
import com.example.ui.theme.RatingGreen
import com.example.ui.theme.StarGold
import com.example.ui.theme.VegGreen
import com.example.ui.theme.ZomatoRed
import com.example.ui.theme.ZomatoRedLight

@Composable
fun FilterChipsRow(
    selectedCuisine: String,
    onSelectCuisine: (String) -> Unit,
    isVegOnly: Boolean,
    onToggleVeg: () -> Unit,
    minRating: Float,
    onToggleRating: () -> Unit,
    fastDeliveryOnly: Boolean,
    onToggleFastDelivery: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Quick Toggle Chips Row
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Veg Only Chip
            item {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (isVegOnly) VegGreen else MaterialTheme.colorScheme.surface,
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        if (isVegOnly) VegGreen else Gray300
                    ),
                    modifier = Modifier
                        .clickable(onClick = onToggleVeg)
                        .testTag("filter_veg_only")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)
                    ) {
                        VegNonVegBadge(isVeg = true, size = 12.dp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Pure Veg",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = if (isVegOnly) Color.White else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // Rating 4.0+ Chip
            item {
                val ratingSelected = minRating > 0f
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (ratingSelected) StarGold else MaterialTheme.colorScheme.surface,
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        if (ratingSelected) StarGold else Gray300
                    ),
                    modifier = Modifier
                        .clickable(onClick = onToggleRating)
                        .testTag("filter_rating_4plus")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)
                    ) {
                        Text(
                            text = "Rating 4.0+",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = if (ratingSelected) Color.White else MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            tint = if (ratingSelected) Color.White else StarGold,
                            modifier = Modifier.size(13.dp)
                        )
                    }
                }
            }

            // Fast Delivery Under 25m Chip
            item {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (fastDeliveryOnly) ZomatoRed else MaterialTheme.colorScheme.surface,
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        if (fastDeliveryOnly) ZomatoRed else Gray300
                    ),
                    modifier = Modifier
                        .clickable(onClick = onToggleFastDelivery)
                        .testTag("filter_fast_delivery")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ElectricBolt,
                            contentDescription = null,
                            tint = if (fastDeliveryOnly) Color.White else ZomatoRed,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Fast Delivery (<25m)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = if (fastDeliveryOnly) Color.White else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // "WHAT'S ON YOUR MIND?" Cuisine Selection Carousel
        Text(
            text = "WHAT'S ON YOUR MIND?",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Gray700,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(SampleData.cuisinesList) { cuisine ->
                val isSelected = selectedCuisine.equals(cuisine, ignoreCase = true)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable { onSelectCuisine(cuisine) }
                        .testTag("cuisine_chip_$cuisine")
                ) {
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(CircleShape)
                            .background(if (isSelected) ZomatoRedLight else Gray100)
                            .border(
                                width = if (isSelected) 2.dp else 1.dp,
                                color = if (isSelected) ZomatoRed else Color.Transparent,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        // Food emoji icon for cuisine
                        val emoji = when (cuisine.lowercase()) {
                            "biryani" -> "🍚"
                            "pizza" -> "🍕"
                            "burger" -> "🍔"
                            "north indian" -> "🥘"
                            "pure veg" -> "🥗"
                            "chinese" -> "🥢"
                            "desserts" -> "🍰"
                            "healthy" -> "🥑"
                            else -> "🍽️"
                        }
                        Text(text = emoji, fontSize = 24.sp)
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = cuisine,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) ZomatoRed else MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}
