package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = ZomatoRed,
    onPrimary = Color.White,
    primaryContainer = ZomatoRedDark,
    onPrimaryContainer = Color.White,
    secondary = ZomatoGold,
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF3A3114),
    onSecondaryContainer = ZomatoGoldLight,
    background = ZomatoDarkBackground,
    onBackground = Color(0xFFF1F1F5),
    surface = ZomatoDarkSurface,
    onSurface = Color(0xFFEDEDF2),
    surfaceVariant = Color(0xFF26262E),
    onSurfaceVariant = Color(0xFFC7C7D1),
    outline = Color(0xFF3F3F4A)
)

private val LightColorScheme = lightColorScheme(
    primary = ZomatoRed,
    onPrimary = Color.White,
    primaryContainer = ZomatoRedLight,
    onPrimaryContainer = ZomatoRedDark,
    secondary = ZomatoGold,
    onSecondary = Color.Black,
    secondaryContainer = ZomatoGoldLight,
    onSecondaryContainer = ZomatoGoldDark,
    background = Color(0xFFF7F8FA),
    onBackground = Gray900,
    surface = Color.White,
    onSurface = Gray900,
    surfaceVariant = Gray100,
    onSurfaceVariant = Gray600,
    outline = Gray200
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Keep Zomato brand red identity consistent
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
