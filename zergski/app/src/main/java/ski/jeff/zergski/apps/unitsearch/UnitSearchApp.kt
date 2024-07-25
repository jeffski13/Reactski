package ski.jeff.zergski.apps.unitsearch

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun UnitSearchApp() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            Row {
                SearchBar()
            }
            Row {
                RaceCategory(Race.previewInfo.name, Race.previewInfo.iconId)
            }
        }
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun previewUnitSearchApp() {
    ZergskiTheme {
        UnitSearchApp()
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun previewUnitSearchAppNightMode() {
    ZergskiTheme {
        UnitSearchApp()
    }
}