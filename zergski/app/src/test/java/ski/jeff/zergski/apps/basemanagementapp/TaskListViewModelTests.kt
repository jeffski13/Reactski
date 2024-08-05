package ski.jeff.zergski.apps.basemanagementapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TaskListViewModelTests {
    @Test
    fun `taks list initialized correctly`() {
        val taskListViewModel = TaskListViewModel()
        assertEquals(true, taskListViewModel.taskList.size > 0)
    }

    @Test
    fun `check marks take effect`() {
        val taskListViewModel = TaskListViewModel()
        taskListViewModel.createTask("mocktask")
        taskListViewModel.onTaskStateUpdated(taskListViewModel.taskList.last(), true)
        assertEquals(true, taskListViewModel.taskList.last().isChecked.value)
    }


    @Test
    fun `removal of task works`() {
        val taskListViewModel = TaskListViewModel()
        taskListViewModel.createTask("mocktask")
        val amountOfBaseTasksBeforeRemove = taskListViewModel.taskList.size
        taskListViewModel.removeBaseTask(taskListViewModel.taskList.last())
        val expectedAmountOfBaseTasksAfterRemoval = amountOfBaseTasksBeforeRemove - 1
        assertEquals(expectedAmountOfBaseTasksAfterRemoval, taskListViewModel.taskList.size)
    }
}