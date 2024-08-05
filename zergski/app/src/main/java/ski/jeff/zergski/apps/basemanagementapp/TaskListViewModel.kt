package ski.jeff.zergski.apps.basemanagementapp

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import java.util.UUID

class TaskListViewModel: ViewModel() {
    private val _baseTaskList = BaseTaskProvider.getBaseTaskList().toMutableStateList()
    val taskList: List<BaseTask> = _baseTaskList
    fun removeBaseTask(task: BaseTask) {
        _baseTaskList.remove(task)
    }

    fun createTask(taskDescription: String) {
        _baseTaskList.add(BaseTask(UUID.randomUUID().toString(), taskDescription))
    }

    fun onTaskStateUpdated(task: BaseTask, state: Boolean) {
        println("onTaskStateUpdated: ${task.id} $state")
        task.isChecked.value = state
    }

}