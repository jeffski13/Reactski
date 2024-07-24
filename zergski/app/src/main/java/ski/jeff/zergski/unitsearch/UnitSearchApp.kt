package ski.jeff.zergski.unitsearch

import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun UnitSearchApp() {
    SearchBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    @Suppress("CompilationErrorException")
    TextField(value = "", onValueChange = {})
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