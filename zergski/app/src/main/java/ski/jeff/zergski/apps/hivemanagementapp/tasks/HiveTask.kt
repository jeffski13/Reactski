package ski.jeff.zergski.apps.hivemanagementapp.tasks

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * a task for keeping up with a Base.
 * Examples could be spawning more drones, collecting more minerals, create more creep colonies, etc.
 */
data class HiveTask(val id: String, val taskDescription: String, var isChecked: MutableState<Boolean> = mutableStateOf( false))