package ski.jeff.zergski.apps.hivemanagementapp.tasks

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HiveTaskListView(taskList: List<HiveTask>,
    onCheckStateChange: (HiveTask, Boolean) -> Unit,
    onXPressed: (HiveTask) -> Unit,
    modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier) {
        items(items = taskList, key = {it.id}) { task ->
            HiveTaskView(task.taskDescription, task.isChecked.value,
                {
                    onCheckStateChange(task, it)
                }, {
                    onXPressed(task)
                }
            )
        }
    }

}