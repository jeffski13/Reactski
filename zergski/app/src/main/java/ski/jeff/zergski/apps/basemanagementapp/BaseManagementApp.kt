package ski.jeff.zergski.apps.basemanagementapp

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ski.jeff.zergski.apps.basemanagementapp.dronespawn.DroneSpawnViewModel
import ski.jeff.zergski.apps.basemanagementapp.dronespawn.NumberOfDrones
import ski.jeff.zergski.apps.basemanagementapp.tasks.BaseTaskListView
import ski.jeff.zergski.apps.basemanagementapp.tasks.CreateTaskDialog
import ski.jeff.zergski.apps.basemanagementapp.tasks.TaskManagerViewModel
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun BaseManagementApp(modifier: Modifier = Modifier,
    droneSpawnViewModel: DroneSpawnViewModel = viewModel(),
    taskManagerViewModel: TaskManagerViewModel = viewModel()){
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