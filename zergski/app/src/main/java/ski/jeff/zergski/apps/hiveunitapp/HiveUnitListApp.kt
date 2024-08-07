package ski.jeff.zergski.apps.hiveunitapp

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun HiveUnitListApp(hiveUnitAppViewModel: HiveUnitAppViewModel = viewModel()) {

    Surface {
        if (hiveUnitAppViewModel.isShowingWelcome.value) {
            WelcomeToZergski(onStartClicked = {hiveUnitAppViewModel.onStartClicked()})
        } else {
            Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground).fillMaxSize()) {
                Button(onClick = { hiveUnitAppViewModel.onHomeClicked() }) {
                    Text("Home")
                }
                LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
                    items(items = hiveUnitAppViewModel.hiveUnitInfoCardDataList) { nextCreatureCardData ->
                        println("creating another card with ${nextCreatureCardData.index}")
                        HiveUnitInfoCard(nextCreatureCardData)
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
        HiveUnitListApp()
    }
}

@Preview(showBackground = true, widthDp = 415, heightDp = 820,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnyNameSkiForPreviewDarkMode() {
    ZergskiTheme {
        HiveUnitListApp()
    }
}
