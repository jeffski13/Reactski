package ski.jeff.zergski.hivecreatureapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.WelcomeToZergski
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun HiveCreaureListApp(hiveCreatureInfoCardDataList: List<HiveCreatureInfoCardData> = listOf()) {
    var isShowingWelcome by rememberSaveable { mutableStateOf(true) }


    Surface {
        if (isShowingWelcome) {
            WelcomeToZergski(onStartClicked = { isShowingWelcome = !isShowingWelcome })
        } else {
            Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground).fillMaxSize()) {
                Button(onClick = { isShowingWelcome = !isShowingWelcome }) {
                    Text("Home")
                }
                LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
                    items(items = hiveCreatureInfoCardDataList) { nextCreatureCardData ->
                        HiveCreatureInfoCard(nextCreatureCardData)
                    }
                }
            }
        }
    }

}


@Preview(showBackground = true, widthDp = 415, heightDp = 820,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AnyNameSkiForPreview() {
    ZergskiTheme {
        HiveCreaureListApp(HiveCreatureListProvider().getPreviewList())
    }
}

@Preview(showBackground = true, widthDp = 415, heightDp = 820,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnyNameSkiForPreviewDarkMode() {
    ZergskiTheme {
        HiveCreaureListApp(HiveCreatureListProvider().getPreviewList())
    }
}
