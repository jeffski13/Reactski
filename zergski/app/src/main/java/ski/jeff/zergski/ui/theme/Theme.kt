package ski.jeff.zergski.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    secondary = dark_secondary,
    tertiary = dark_tertiary,
    onBackground = dark_onBackground,
    surface = dark_surface,
    onSurface = dark_onSurface,
    primary = dark_primary,
    onPrimary = dark_onPrimary,
    onSecondary =dark_onSecondary,
    onTertiary = dark_onTertiary,
    onPrimaryContainer = dark_onPrimaryContainer,
    onSecondaryContainer = dark_onSecondaryContainer,
    onTertiaryContainer = dark_onTertiaryContainer,
    onSurfaceVariant = dark_onSurfaceVariant,
)

private val LightColorScheme = lightColorScheme(
    secondary = light_secondary,
    tertiary = light_tertiary,
    onBackground = light_onBackground,
    surface = light_surface,
    onSurface = light_onSurface,
    primary = light_primary,
    onPrimary = light_onPrimary,
    onSecondary =light_onSecondary,
    onTertiary = light_onTertiary,
    onPrimaryContainer = light_onPrimaryContainer,
    onSecondaryContainer = light_onSecondaryContainer,
    onTertiaryContainer = light_onTertiaryContainer,
    onSurfaceVariant = light_onSurfaceVariant,


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onSurface = Color(0xFF1C1B1F),
    */)

/**
 * @param dynamicColor in Android 12+[`]
 */
@Composable
fun ZergskiTheme(darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit) {

    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }


    MaterialTheme(colorScheme = colorScheme,
        typography = Typography,
        content = content)
}