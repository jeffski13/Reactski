package ski.jeff.zergski.apps.unitsearch

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.R
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun SearchAppSection(
    @StringRes titleId: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit) {
    Column(modifier = modifier) {
        Text(text = stringResource(titleId),
            modifier = Modifier.
                paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleLarge)
        content()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun previewSearchAppSection() {
    ZergskiTheme {
        SearchAppSection(R.string.buildingList_sectionTitle) {
            BuildingListRow()
        }
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun previewSearchAppSectionDarkMode() {
    ZergskiTheme {
        SearchAppSection(R.string.buildingList_sectionTitle) {
            BuildingListRow()
        }
    }
}