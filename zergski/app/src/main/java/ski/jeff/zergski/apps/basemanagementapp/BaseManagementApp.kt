package ski.jeff.zergski.apps.basemanagementapp

import android.content.res.Configuration
import android.view.KeyEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun BaseManagementApp(modifier: Modifier = Modifier,
    droneSpawnViewModel: DroneSpawnViewModel= viewModel(),
    taskManagerViewModel: TaskManagerViewModel= viewModel()){
    ZergskiTheme {
        Scaffold(modifier = modifier, floatingActionButton = { ExtendedExample({
            taskManagerViewModel.onOpenCreateTaskDialogueClicked()
        }) }) {
            Surface(color = MaterialTheme.colorScheme.surface, modifier = Modifier
                .fillMaxSize()
                .padding(it)) {
                Column {
                    NumberOfDrones(
                        dronesHatched = droneSpawnViewModel.dronesHatched.value,
                        onSpawnDrone= {droneSpawnViewModel.spawnDrone()},
                        isButtonEnabled =  droneSpawnViewModel.isAddDroneEnabled,
                        isDroneCountShowing = droneSpawnViewModel.isDroneCountShowing
                    )
                    BaseTaskListView(
                        taskList = taskManagerViewModel.taskList,
                        onCheckStateChange = { task, state -> taskManagerViewModel.onTaskStateUpdated(task, state) },
                        onXPressed = {taskManagerViewModel.removeBaseTask(it)}
                    )
                }
                if(taskManagerViewModel.isShowingCreateBaseTask.value) {
                    CreateTaskDialog(
                        onDismissRequest = { taskManagerViewModel.onDismissCreateTaskClicked() },
                        onConfirmation = {
                            taskManagerViewModel.onConfirmCreateTaskClicked()
                            println("Confirmation registered") // Add logic here to handle confirmation.
                        },
                        dialogTitle = "Alert dialog example",
                        dialogText = "This is an example of an alert dialog with buttons.",
                        newTaskText = taskManagerViewModel.createTaskText,
                        onNewTaskTextUpdated = { taskManagerViewModel.onNewTaskTextUpdated(it) },
                        onEnterClicked = { taskManagerViewModel.onEnterClickedDuringNewTask() },
                    )
                }
            }
        }
    }
}

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
    AlertDialog(
        icon = {
            Icon(Icons.Default.Info, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
            TaskCreateEditField(newTaskText, onNewTaskTextUpdated, onEnterClicked)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Create")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
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


@Composable
fun ExtendedExample(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.Edit, "Create Base Task.") },
        text = { Text(text = "Base Task") },
    )
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