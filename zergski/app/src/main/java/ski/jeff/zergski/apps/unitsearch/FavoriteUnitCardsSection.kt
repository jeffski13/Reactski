package ski.jeff.zergski.apps.unitsearch

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun FavoriteUnitCardsSection(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(modifier = modifier.height(168.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        rows = GridCells.Fixed(2)
    ) {
        items(FavoriteUnitCardInfoListProvider.getList()) {
            FavoriteUnitCard(favoriteUnitCardInfo = it,
                modifier = Modifier.height(80.dp))
        }
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun previewFavoriteUnitCardsSection() {
    ZergskiTheme {
        FavoriteUnitCardsSection()
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun previewFavoriteUnitCardsSectionDarkMode() {
    ZergskiTheme {
        FavoriteUnitCardsSection()
    }
}