package ski.jeff.zergski.apps.hivemanagementapp.tasks

import java.util.UUID

class HiveTaskProvider {
    companion object {
        fun getBaseTaskList(): List<HiveTask> {
            println("getBaseTaskList()")
            val tasklist = mutableListOf<HiveTask>()
            for(i in 1..2) {
                tasklist.add(HiveTask(UUID.randomUUID().toString(), "directions for drone $i"))
            }
            return tasklist
        }
    }
}