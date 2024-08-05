package ski.jeff.zergski.apps.basemanagementapp

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun BaseManagementApp(modifier: Modifier = Modifier,
    droneSpawnViewModel: DroneSpawnViewModel= viewModel(),
    taskListViewModel: TaskListViewModel= viewModel()){
    ZergskiTheme {
        Surface(color = MaterialTheme.colorScheme.surface, modifier = Modifier.fillMaxSize()) {
            Column {
                NumberOfDrones(
                    dronesHatched = droneSpawnViewModel.dronesHatched.value,
                    onSpawnDrone= {droneSpawnViewModel.spawnDrone()},
                    isButtonEnabled =  droneSpawnViewModel.isAddDroneEnabled,
                    isDroneCountShowing = droneSpawnViewModel.isDroneCountShowing
                )
                BaseTaskListView(
                    taskList = taskListViewModel.taskList,
                    onCheckStateChange = { task, state -> taskListViewModel.onTaskStateUpdated(task, state) },
                    onXPressed = {taskListViewModel.removeBaseTask(it)}
                )
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