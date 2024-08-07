package ski.jeff.zergski.apps.hivemanagementapp.tasks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import java.util.UUID

class TaskManagerViewModel: ViewModel() {
    private val _isShowingCreateBaseTask = mutableStateOf(false)
    val isShowingCreateBaseTask: State<Boolean> = _isShowingCreateBaseTask

    private val _createTaskText = mutableStateOf("")
    val createTaskText: State<String> = _createTaskText

    private val _baseTaskList = HiveTaskProvider.getBaseTaskList().toMutableStateList()
    val taskList: List<HiveTask> = _baseTaskList
    fun removeBaseTask(task: HiveTask) {
        _baseTaskList.remove(task)
    }

    fun onTaskStateUpdated(task: HiveTask, state: Boolean) {
        println("onTaskStateUpdated: ${task.id} $state")
        task.isChecked.value = state
    }

    fun onOpenCreateTaskDialogueClicked() {
        _isShowingCreateBaseTask.value = true
    }

    fun onDismissCreateTaskClicked() {
        _createTaskText.value = ""
        _isShowingCreateBaseTask.value = false
    }

    fun onConfirmCreateTaskClicked() {
        if(_isShowingCreateBaseTask.value) {
            _baseTaskList.add(HiveTask(UUID.randomUUID().toString(), _createTaskText.value))
            _createTaskText.value = ""
            _isShowingCreateBaseTask.value = false
        }
    }

    fun onNewTaskTextUpdated(taskText: String) {
        _createTaskText.value = taskText
    }

    fun onEnterClickedDuringNewTask() {
        onConfirmCreateTaskClicked()
    }

}