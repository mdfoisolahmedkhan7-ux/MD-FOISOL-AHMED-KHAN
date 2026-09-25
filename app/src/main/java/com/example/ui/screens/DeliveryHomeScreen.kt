package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.local.FavoriteEntity
import com.example.data.model.Restaurant
import com.example.ui.components.FilterChipsRow
import com.example.ui.components.RestaurantCard
import com.example.ui.components.TopHeaderBar
import com.example.ui.theme.Gray100
import com.example.ui.theme.Gray500
import com.example.ui.theme.Gray700
import com.example.ui.theme.ZomatoGold
import com.example.ui.theme.ZomatoRed
import com.example.ui.theme.ZomatoRedLight

@Composable
fun DeliveryHomeScreen(
    restaurants: List<Restaurant>,
    favorites: List<FavoriteEntity>,
    currentAddress: String,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    selectedCuisine: String,
    onSelectCuisine: (String) -> Unit,
    isVegOnly: Boolean,
    onToggleVeg: () -> Unit,
    minRating: Float,
    onToggleRating: () -> Unit,
    fastDeliveryOnly: Boolean,
    onToggleFastDelivery: () -> Unit,
    onRestaurantClick: (Restaurant) -> Unit,
    onFavoriteToggle: (Restaurant) -> Unit,
    onAddressClick: () -> Unit,
    onProfileClick: () -> Unit,
    onResetFilters: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Sticky Header with Location, Veg Mode switch & Search
        TopHeaderBar(
            currentAddress = currentAddress,
            onAddressClick = onAddressClick,
            searchQuery = searchQuery,
            onSearchChange = onSearchChange,
            isVegOnly = isVegOnly,
            onVegOnlyToggle = { onToggleVeg() },
            onProfileClick = onProfileClick
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .testTag("delivery_restaurants_list"),
            contentPadding = PaddingValues(bottom = 90.dp)
        ) {
            // Hero Promo Carousel Banner
            if (searchQuery.isBlank()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                            .height(160.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_hero_banner),
                            contentDescription = "Great Indian Feast Banner",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            Color.Black.copy(alpha = 0.85f),
                                            Color.Black.copy(alpha = 0.4f),
                                            Color.Transparent
                                        )
                                    )
                                )
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(18.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = ZomatoRed
                            ) {
                                Text(
                                    text = "FESTIVE CARNIVAL",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "FLAT 50% OFF",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                            Text(
                                text = "Free Delivery on Top Rated Brands",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White.copy(alpha = 0.9f)
                            )
                        }
                    }
                }

                // Filter & "What's on your mind?" cuisines
                item {
                    Spacer(modifier = Modifier.height(6.dp))
                    FilterChipsRow(
                        selectedCuisine = selectedCuisine,
                        onSelectCuisine = onSelectCuisine,
                        isVegOnly = isVegOnly,
                        onToggleVeg = onToggleVeg,
                        minRating = minRating,
                        onToggleRating = onToggleRating,
                        fastDeliveryOnly = fastDeliveryOnly,
                        onToggleFastDelivery = onToggleFastDelivery
                    )
                }

                // Top Brands Strip
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "TOP BRANDS FOR YOU",
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
                        items(restaurants) { rest ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .width(80.dp)
                                    .clickable { onRestaurantClick(rest) }
                                    .testTag("top_brand_${rest.id}")
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(64.dp)
                                        .clip(CircleShape)
                                        .background(Gray100),
                                    contentAlignment = Alignment.Center
                                ) {
                                    val img = rest.bannerDrawableRes ?: R.drawable.img_hero_banner
                                    Image(
                                        painter = painterResource(id = img),
                                        contentDescription = rest.name,
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = rest.name,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "${rest.deliveryTimeMin} min",
                                    fontSize = 10.sp,
                                    color = Gray500
                                )
                            }
                        }
                    }
                }
            }

            // Section Title
            item {
                Spacer(modifier = Modifier.height(18.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (searchQuery.isNotBlank()) "SEARCH RESULTS" else "ALL RESTAURANTS",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Gray700,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "${restaurants.size} places around you",
                        fontSize = 12.sp,
                        color = Gray500
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Restaurant Cards
            if (restaurants.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Restaurant,
                            contentDescription = null,
                            tint = Gray500,
                            modifier = Modifier.size(54.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "No matching restaurants found",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Try adjusting your filters or search keywords",
                            fontSize = 13.sp,
                            color = Gray500
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = onResetFilters,
                            colors = ButtonDefaults.buttonColors(containerColor = ZomatoRed),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text("Reset Filters")
                        }
                    }
                }
            } else {
                items(restaurants, key = { it.id }) { restaurant ->
                    val isFav = favorites.any { it.restaurantId == restaurant.id }
                    RestaurantCard(
                        restaurant = restaurant,
                        isFavorite = isFav,
                        onFavoriteToggle = { onFavoriteToggle(restaurant) },
                        onClick = { onRestaurantClick(restaurant) },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}
