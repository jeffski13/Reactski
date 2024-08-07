package ski.jeff.zergski.apps.hivemanagementapp.tasks

import android.view.KeyEvent
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.input.ImeAction

@Composable
fun CreateTaskDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    newTaskText: State<String>,
    onNewTaskTextUpdated: (String) -> Unit,
    onEnterClicked: () -> Unit,
) {
    AlertDialog(icon = {
        Icon(Icons.Default.Info, contentDescription = "Example Icon")
    }, title = {
        Text(text = dialogTitle)
    }, text = {
        Text(text = dialogText)
        TaskCreateEditField(newTaskText, onNewTaskTextUpdated, onEnterClicked)
    }, onDismissRequest = {
        onDismissRequest()
    }, confirmButton = {
        TextButton(onClick = {
            onConfirmation()
        }) {
            Text("Create")
        }
    }, dismissButton = {
        TextButton(onClick = {
            onDismissRequest()
        }) {
            Text("Dismiss")
        }
    })
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TaskCreateEditField(currentValue: State<String>,
    onValueChanged: (String)-> Unit,
    onEnterClicked: () -> Unit,
) {
    TextField(
        value = currentValue.value,
        onValueChange = onValueChanged,
        label = { Text("Label") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {}
        ),
        modifier = Modifier.onKeyEvent {
            if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER){
                onEnterClicked()
                true
            }
            false
        }
    )
}
