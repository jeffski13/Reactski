package ski.jeff.zergski.apps.hivemanagementapp.tasks

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.ui.theme.ZergskiTheme


@Composable
fun HiveTaskView(taskText: String,
    isChecked: Boolean,
    onCheckboxClicked: (Boolean) -> Unit,
    onXClicked: () -> Unit,
    modifier: Modifier = Modifier){

    Surface(color = MaterialTheme.colorScheme.surfaceVariant) {
        Row(modifier = modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Column(modifier = Modifier.weight(0.7f)) {
                Text(taskText, color = MaterialTheme.colorScheme.onSurface)
            }
            Column(modifier = Modifier
                .weight(0.15f)
                .fillMaxWidth()) {
                Checkbox(checked = isChecked, onCheckedChange = onCheckboxClicked)
            }
            Column(modifier = Modifier.weight(0.15f)) {
                IconButton(onClick = onXClicked) {
                    Icon(Icons.Filled.Close, contentDescription = null)
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, widthDp = 300)
@Composable
fun previewBaseTask() {
    ZergskiTheme {
        HiveTaskView("yo", false, {}, {})
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, widthDp = 300)
@Composable
fun previewBaseTaskDarkMode() {
    ZergskiTheme {
        HiveTaskView("yo", false, {}, {})
    }
}