package ski.jeff.zergski.apps.basemanagementapp

class BaseTaskProvider {
    companion object {
        fun getBaseTaskList(): List<BaseTask> {
            println("getBaseTaskList()")
            val tasklist = mutableListOf<BaseTask>()
            for(i in 1..2) {
                tasklist.add(BaseTask(i, "directions for drone $i", false))
            }
            return tasklist
        }
    }
}