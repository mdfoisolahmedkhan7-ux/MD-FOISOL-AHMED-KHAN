package com.example.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.RatingGreen
import com.example.ui.theme.ZomatoRed

@Composable
fun LiveDeliveryMap(
    restaurantName: String,
    stepProgress: Float, // 0.0f (placed) to 1.0f (delivered)
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseRadius by infiniteTransition.animateFloat(
        initialValue = 12f,
        targetValue = 28f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "pulseRadius"
    )
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.7f,
        targetValue = 0.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "pulseAlpha"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFE8ECEF))
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height

            // Background Stylized Map Roads / Blocks
            val roadColor = Color(0xFFD6DBDF)
            val buildingColor = Color(0xFFF1F3F5)

            // Draw city grid blocks
            drawRect(color = buildingColor, topLeft = Offset(w * 0.05f, h * 0.08f), size = androidx.compose.ui.geometry.Size(w * 0.35f, h * 0.3f))
            drawRect(color = buildingColor, topLeft = Offset(w * 0.45f, h * 0.08f), size = androidx.compose.ui.geometry.Size(w * 0.48f, h * 0.35f))
            drawRect(color = buildingColor, topLeft = Offset(w * 0.05f, h * 0.55f), size = androidx.compose.ui.geometry.Size(w * 0.45f, h * 0.35f))
            drawRect(color = buildingColor, topLeft = Offset(w * 0.55f, h * 0.55f), size = androidx.compose.ui.geometry.Size(w * 0.38f, h * 0.35f))

            // Main Roads
            drawLine(color = roadColor, start = Offset(0f, h * 0.45f), end = Offset(w, h * 0.45f), strokeWidth = 14f)
            drawLine(color = roadColor, start = Offset(w * 0.48f, 0f), end = Offset(w * 0.48f, h), strokeWidth = 14f)
            drawLine(color = Color.White, start = Offset(0f, h * 0.45f), end = Offset(w, h * 0.45f), strokeWidth = 2f,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 15f)))

            // Restaurant coordinates (Start)
            val restX = w * 0.18f
            val restY = h * 0.35f

            // Delivery destination coordinates (End - Home)
            val homeX = w * 0.82f
            val homeY = h * 0.72f

            // Curved delivery path
            val path = Path().apply {
                moveTo(restX, restY)
                cubicTo(
                    restX + (homeX - restX) * 0.3f, restY,
                    restX + (homeX - restX) * 0.6f, homeY,
                    homeX, homeY
                )
            }

            // Draw route background path
            drawPath(
                path = path,
                color = Color(0xFF263238),
                style = Stroke(
                    width = 6f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 12f), 0f)
                )
            )

            // Current delivery bike position along the curve (interpolated)
            val t = stepProgress.coerceIn(0.05f, 0.95f)
            val curX = (1 - t) * (1 - t) * (1 - t) * restX +
                    3 * (1 - t) * (1 - t) * t * (restX + (homeX - restX) * 0.3f) +
                    3 * (1 - t) * t * t * (restX + (homeX - restX) * 0.6f) +
                    t * t * t * homeX

            val curY = (1 - t) * (1 - t) * (1 - t) * restY +
                    3 * (1 - t) * (1 - t) * t * restY +
                    3 * (1 - t) * t * t * homeY +
                    t * t * t * homeY

            // Pulse wave around valet
            drawCircle(
                color = ZomatoRed.copy(alpha = pulseAlpha),
                radius = pulseRadius * 1.5f,
                center = Offset(curX, curY)
            )

            // Draw Valet Pin (Red with White Center)
            drawCircle(
                color = ZomatoRed,
                radius = 16f,
                center = Offset(curX, curY)
            )
            drawCircle(
                color = Color.White,
                radius = 8f,
                center = Offset(curX, curY)
            )

            // Restaurant Marker (Green)
            drawCircle(
                color = RatingGreen,
                radius = 14f,
                center = Offset(restX, restY)
            )
            drawCircle(
                color = Color.White,
                radius = 6f,
                center = Offset(restX, restY)
            )

            // Home Destination Marker (Blue)
            drawCircle(
                color = Color(0xFF1E88E5),
                radius = 14f,
                center = Offset(homeX, homeY)
            )
            drawCircle(
                color = Color.White,
                radius = 6f,
                center = Offset(homeX, homeY)
            )
        }

        // Live ETA overlay pill
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = Color.Black.copy(alpha = 0.8f),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 10.dp)
        ) {
            Text(
                text = "⚡ Live Delivery Route • On Time",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
    }
}
