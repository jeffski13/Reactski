package ski.jeff.zergski.apps.basemanagementapp

import java.util.UUID

class BaseTaskProvider {
    companion object {
        fun getBaseTaskList(): List<BaseTask> {
            println("getBaseTaskList()")
            val tasklist = mutableListOf<BaseTask>()
            for(i in 1..2) {
                tasklist.add(BaseTask(UUID.randomUUID().toString(), "directions for drone $i"))
            }
            return tasklist
        }
    }
}