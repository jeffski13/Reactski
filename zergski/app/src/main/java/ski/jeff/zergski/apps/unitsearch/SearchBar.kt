package ski.jeff.zergski.apps.unitsearch

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.ui.theme.ZergskiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    TextField(value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Unit")
        },
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text("Unit Name")
        }

    )
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO,
    heightDp = 100)
@Composable
fun previewSearchBar() {
    ZergskiTheme {
        SearchBar()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
    heightDp = 100)
@Composable
fun previewSearchBarNightMode() {
    ZergskiTheme {
        SearchBar()
    }
}