package ski.jeff.zergski.apps.basemanagementapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun BaseTaskListView(taskList: List<BaseTask>,
    onCheckStateChange: (BaseTask, Boolean) -> Unit,
    onXPressed: (BaseTask) -> Unit,
    modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier) {
        items(items = taskList, key = {it.id}) { task ->
            BaseTaskView(task.taskDescription, task.isChecked.value,
                {
                    onCheckStateChange(task, it)
                }, {
                    onXPressed(task)
                }
            )
        }
    }

}