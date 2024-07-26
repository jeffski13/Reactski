package ski.jeff.zergski.apps.unitsearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BuildingListRow(modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(BuildingListProvider.getList()) { item ->
            BuildingView(categoryName = item.name, iconId = item.iconId)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewRaceCategoryRow() {
    BuildingListRow()
}
