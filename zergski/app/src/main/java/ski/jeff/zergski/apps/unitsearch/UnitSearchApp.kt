package ski.jeff.zergski.apps.unitsearch

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.R
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun UnitSearchApp(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = modifier.verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            SearchAppSection(titleId = R.string.buildingList_sectionTitle) {
                BuildingListRow(Modifier.padding(16.dp))
            }
            SearchAppSection(titleId = R.string.favoriteUnits_sectionTitle) {
                FavoriteUnitCardsSection()
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Preview (uiMode = Configuration.UI_MODE_NIGHT_NO, heightDp = 180)
@Composable
fun previewUnitSearchAppWithScroll() {
    ZergskiTheme {
        UnitSearchApp()
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

