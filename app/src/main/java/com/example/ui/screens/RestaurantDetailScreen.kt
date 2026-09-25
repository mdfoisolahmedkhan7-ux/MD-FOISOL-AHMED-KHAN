package com.example.ui.screens

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.data.local.CartItemEntity
import com.example.data.model.Dish
import com.example.data.model.Restaurant
import com.example.ui.components.DishItemRow
import com.example.ui.components.VegNonVegBadge
import com.example.ui.theme.Gray100
import com.example.ui.theme.Gray200
import com.example.ui.theme.Gray300
import com.example.ui.theme.Gray500
import com.example.ui.theme.Gray700
import com.example.ui.theme.RatingGreen
import com.example.ui.theme.StarGold
import com.example.ui.theme.VegGreen
import com.example.ui.theme.ZomatoGoldLight
import com.example.ui.theme.ZomatoRed
import com.example.ui.theme.ZomatoRedLight

@Composable
fun RestaurantDetailScreen(
    restaurant: Restaurant,
    cartItems: List<CartItemEntity>,
    isFavorite: Boolean,
    onBack: () -> Unit,
    onFavoriteToggle: () -> Unit,
    onAddToCart: (Dish) -> Unit,
    onIncrement: (CartItemEntity) -> Unit,
    onDecrement: (CartItemEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler { onBack() }

    var vegOnlyFilter by remember { mutableStateOf(false) }
    var selectedCategoryIndex by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Collapsing Top Image Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            val imgRes = restaurant.bannerDrawableRes ?: R.drawable.img_hero_banner
            Image(
                painter = painterResource(id = imgRes),
                contentDescription = restaurant.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Scrim
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Black.copy(alpha = 0.6f), Color.Transparent, Color.Black.copy(alpha = 0.7f))
                        )
                    )
            )

            // Top Actions Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .size(38.dp)
                        .background(Color.Black.copy(alpha = 0.5f), CircleShape)
                        .testTag("detail_back_btn")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Row {
                    IconButton(
                        onClick = onFavoriteToggle,
                        modifier = Modifier
                            .size(38.dp)
                            .background(Color.Black.copy(alpha = 0.5f), CircleShape)
                            .testTag("detail_favorite_btn")
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (isFavorite) ZomatoRed else Color.White
                        )
                    }
                }
            }

            // Bottom restaurant info badge overlay
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp),
                shape = RoundedCornerShape(8.dp),
                color = Color.Black.copy(alpha = 0.75f)
            ) {
                Text(
                    text = "⏱ ${restaurant.deliveryTimeMin}-${restaurant.deliveryTimeMax} min • ${restaurant.distanceKm} km",
                    color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        // Restaurant Meta Info Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = restaurant.name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = restaurant.cuisines.joinToString(", "),
                            fontSize = 13.sp,
                            color = Gray500
                        )
                        Text(
                            text = restaurant.address,
                            fontSize = 12.sp,
                            color = Gray500
                        )
                    }

                    // Rating Pill
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = RatingGreen
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                        ) {
                            Text(
                                text = "${restaurant.rating}",
                                color = Color.White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(13.dp)
                            )
                        }
                    }
                }

                if (restaurant.offerText.isNotBlank()) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = ZomatoRedLight,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.LocalOffer,
                                contentDescription = null,
                                tint = ZomatoRed,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = restaurant.offerText,
                                fontSize = 12.sp,
                                color = ZomatoRed,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }

        // Veg Only Filter Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .border(1.dp, if (vegOnlyFilter) VegGreen else Gray300, RoundedCornerShape(20.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                VegNonVegBadge(isVeg = true, size = 12.dp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Veg Only",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (vegOnlyFilter) VegGreen else Gray700
                )
                Spacer(modifier = Modifier.width(6.dp))
                Switch(
                    checked = vegOnlyFilter,
                    onCheckedChange = { vegOnlyFilter = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = VegGreen,
                        uncheckedThumbColor = Gray500,
                        uncheckedTrackColor = Gray100
                    ),
                    modifier = Modifier
                        .size(34.dp, 20.dp)
                        .testTag("restaurant_veg_toggle")
                )
            }

            Text(
                text = "FULL MENU",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Gray500,
                letterSpacing = 1.sp
            )
        }

        // Menu Categories Lazy List
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .testTag("restaurant_dishes_list"),
            contentPadding = PaddingValues(bottom = 90.dp)
        ) {
            restaurant.menuCategories.forEach { category ->
                val filteredDishes = category.dishes.filter {
                    !vegOnlyFilter || it.isVeg
                }

                if (filteredDishes.isNotEmpty()) {
                    item {
                        Surface(
                            color = Gray100,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "${category.name} (${filteredDishes.size})",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Gray700,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                        }
                    }

                    items(filteredDishes, key = { it.id }) { dish ->
                        val cartItem = cartItems.find { it.dishId == dish.id }
                        val quantity = cartItem?.quantity ?: 0

                        DishItemRow(
                            dish = dish,
                            cartQuantity = quantity,
                            onAddToCart = { onAddToCart(dish) },
                            onIncrement = {
                                if (cartItem != null) onIncrement(cartItem)
                                else onAddToCart(dish)
                            },
                            onDecrement = {
                                if (cartItem != null) onDecrement(cartItem)
                            }
                        )
                    }
                }
            }
        }
    }
}
