package com.example.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui.theme.EggAmber
import com.example.ui.theme.NonVegRed
import com.example.ui.theme.VegGreen

@Composable
fun VegNonVegBadge(
    isVeg: Boolean,
    isEgg: Boolean = false,
    modifier: Modifier = Modifier,
    size: Dp = 16.dp
) {
    val borderColor = when {
        isVeg -> VegGreen
        isEgg -> EggAmber
        else -> NonVegRed
    }

    Box(
        modifier = modifier
            .size(size)
            .border(1.2.dp, borderColor, RoundedCornerShape(3.dp)),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .size(size * 0.45f)
                .clip(CircleShape),
            color = borderColor
        ) {}
    }
}
