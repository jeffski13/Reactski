package ski.jeff.zergski.apps.basemanagementapp

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun BaseManagementApp(){
    val dronesHatched = rememberSaveable { mutableStateOf(0) }
    val checkBoxEnabled = rememberSaveable { mutableStateOf(false) }
    val onCheckBoxClicked: (Boolean) -> Unit = {
        checkBoxEnabled.value = it
    }

    ZergskiTheme {
        Surface(color = MaterialTheme.colorScheme.surface, modifier = Modifier.fillMaxSize()) {
            Column {
                NumberOfDrones(dronesHatched.value, {dronesHatched.value++},dronesHatched.value < 5, dronesHatched.value > 0)
                BaseTaskView("howdy", checkBoxEnabled.value, onCheckBoxClicked, {})
            }
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun previewBaseManagementApp() {
    BaseManagementApp()
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun previewBaseManagementAppDarkMode() {
    BaseManagementApp()
}