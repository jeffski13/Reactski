package ski.jeff.zergski.apps.hivemanagementapp

import org.junit.Test

import org.junit.Assert.*
import ski.jeff.zergski.apps.hivemanagementapp.tasks.TaskManagerViewModel

/**
 *
 */
class TaskManagerViewModelTests {
    @Test
    fun `taks list initialized correctly`() {
        val taskManagerViewModel = TaskManagerViewModel()
        assertEquals(true, taskManagerViewModel.taskList.size > 0)
    }

    @Test
    fun `check marks take effect`() {
        val taskManagerViewModel = TaskManagerViewModel()
        taskManagerViewModel.onNewTaskTextUpdated("new task stuff")
        taskManagerViewModel.onConfirmCreateTaskClicked()
        taskManagerViewModel.onTaskStateUpdated(taskManagerViewModel.taskList.last(), true)
        assertEquals(true, taskManagerViewModel.taskList.last().isChecked.value)
    }

    @Test
    fun `removal of task works`() {
        val taskManagerViewModel = TaskManagerViewModel()
        taskManagerViewModel.onNewTaskTextUpdated("new task stuff")
        taskManagerViewModel.onConfirmCreateTaskClicked()
        val amountOfBaseTasksBeforeRemove = taskManagerViewModel.taskList.size
        taskManagerViewModel.removeBaseTask(taskManagerViewModel.taskList.last())
        val expectedAmountOfBaseTasksAfterRemoval = amountOfBaseTasksBeforeRemove - 1
        assertEquals(expectedAmountOfBaseTasksAfterRemoval, taskManagerViewModel.taskList.size)
    }

    @Test
    fun `task creation dialogue opens`() {
        val taskManagerViewModel = TaskManagerViewModel()
        taskManagerViewModel.onOpenCreateTaskDialogueClicked()
        assertEquals(true, taskManagerViewModel.isShowingCreateBaseTask.value)
    }

    @Test
    fun `task creation dialogue closes on dismiss`() {
        val taskManagerViewModel = TaskManagerViewModel()
        taskManagerViewModel.onOpenCreateTaskDialogueClicked()
        taskManagerViewModel.onDismissCreateTaskClicked()
        assertEquals(false, taskManagerViewModel.isShowingCreateBaseTask.value)
    }

    @Test
    fun `task creation works`() {
        val taskManagerViewModel = TaskManagerViewModel()
        val amountOfBaseTasksBeforeAdd = taskManagerViewModel.taskList.size
        taskManagerViewModel.onOpenCreateTaskDialogueClicked()
        taskManagerViewModel.onNewTaskTextUpdated("new task stuff")
        taskManagerViewModel.onConfirmCreateTaskClicked()
        val expectedAmountOfBaseTasksAfterAdd = amountOfBaseTasksBeforeAdd + 1
        assertEquals(expectedAmountOfBaseTasksAfterAdd, taskManagerViewModel.taskList.size)
    }

    @Test
    fun `task creation works with enter key`() {
        val taskManagerViewModel = TaskManagerViewModel()
        val amountOfBaseTasksBeforeAdd = taskManagerViewModel.taskList.size
        taskManagerViewModel.onOpenCreateTaskDialogueClicked()
        taskManagerViewModel.onNewTaskTextUpdated("new task stuff")
        taskManagerViewModel.onEnterClickedDuringNewTask()
        val expectedAmountOfBaseTasksAfterAdd = amountOfBaseTasksBeforeAdd + 1
        assertEquals(expectedAmountOfBaseTasksAfterAdd, taskManagerViewModel.taskList.size)
    }

    @Test
    fun `new task has blank text `() {
        val taskManagerViewModel = TaskManagerViewModel()
        taskManagerViewModel.onOpenCreateTaskDialogueClicked()
        taskManagerViewModel.onNewTaskTextUpdated("new task stuff")
        taskManagerViewModel.onConfirmCreateTaskClicked()
        assertEquals("", taskManagerViewModel.createTaskText.value)
    }

    @Test
    fun `after dismiss create task, new task has blank text`() {
        val taskManagerViewModel = TaskManagerViewModel()
        taskManagerViewModel.onOpenCreateTaskDialogueClicked()
        taskManagerViewModel.onNewTaskTextUpdated("new task stuff")
        taskManagerViewModel.onDismissCreateTaskClicked()
        assertEquals("", taskManagerViewModel.createTaskText.value)
    }

}