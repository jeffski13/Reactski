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
    secondary = LightGreen,
    tertiary = LightPink,
    onBackground = LightBackground,
    surface = LightBackground,
    onSurface = LightBackground,
    primary = LightBackground,
    onPrimary = LightBackground)

private val LightColorScheme = lightColorScheme(
    secondary = PurpleGrey40,
    tertiary = DarkGreen,
    onBackground = DarkBackground,
    surface = DarkBackground,
    onSurface = DarkBackground,
    primary = DarkBackground,
    onPrimary = DarkBackground,
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
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) {
                println("jeffski dark theme")
                dynamicDarkColorScheme(context)
            } else {
                println("jeffski light theme")
                dynamicLightColorScheme(context)
            }
        }

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