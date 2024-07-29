package ski.jeff.zergski.apps.unitsearch

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ski.jeff.zergski.ui.theme.ZergskiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitSearchAppPortrait() {
    ZergskiTheme {
        Scaffold(bottomBar = {
            UnitSearchBottomNavigation()
        }) {
            UnitSearchApp(Modifier.padding(it))
        }
    }
}

@Composable
fun UnitSearchAppLandscape() {
    ZergskiTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                UnitSearchAppNavigationRail()
                UnitSearchApp()
            }
        }
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, heightDp = 500, widthDp = 1080)
@Composable
fun previewUnitSearchAppLandscape() {
    UnitSearchAppLandscape()
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, heightDp = 500, widthDp = 1080)
@Composable
fun previewUnitSearchAppLandscapeDarkMode() {
    UnitSearchAppLandscape()
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun previewUnitSearchAppPortrait() {
    UnitSearchAppPortrait()
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun previewUnitSearchAppPortraitDarkMode() {
    UnitSearchAppPortrait()
}