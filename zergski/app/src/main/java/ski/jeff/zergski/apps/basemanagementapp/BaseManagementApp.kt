package ski.jeff.zergski.apps.basemanagementapp

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun BaseManagementApp(modifier: Modifier = Modifier, baseManagementAppViewModel: BaseManagementAppViewModel= viewModel()){
    ZergskiTheme {
        Surface(color = MaterialTheme.colorScheme.surface, modifier = Modifier.fillMaxSize()) {
            Column {
                NumberOfDrones(baseManagementAppViewModel.dronesHatched.value, {baseManagementAppViewModel.spawnDrone()},baseManagementAppViewModel.isAddDroneEnabled, baseManagementAppViewModel.isDroneCountShowing)
                BaseTaskListView(taskList = baseManagementAppViewModel.baseTaskList, onCheckStateChange = { task, state -> task.onCheckChanged(state)}, onXPressed = {baseManagementAppViewModel.baseTaskList.remove(it)})
            }
        }
    }
}

class BaseManagementAppViewModel: ViewModel() {
    val baseTaskList = BaseTaskProvider.getBaseTaskList().toMutableStateList()
    val dronesHatched = mutableStateOf(0)
    var isAddDroneEnabled = true
    var isDroneCountShowing: Boolean = false

    fun spawnDrone() {
        dronesHatched.value++
        if(dronesHatched.value > 5) {
            isAddDroneEnabled = false
        }
        if(dronesHatched.value > 0) {
            isDroneCountShowing = true
        }
    }

    fun removeBaseTask(task: BaseTask) {
        baseTaskList.remove(task)
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