package ski.jeff.zergski.apps.hivemanagementapp.dronespawn

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DroneSpawnViewModel: ViewModel() {
    val dronesHatched = mutableStateOf(0)
    var isAddDroneEnabled = true
    var isDroneCountShowing: Boolean = false

    fun spawnDrone() {
        if(isAddDroneEnabled) {
            dronesHatched.value++
            if(dronesHatched.value >= 5) {
                isAddDroneEnabled = false
            }
            if(dronesHatched.value > 0) {
                isDroneCountShowing = true
            }
        }
    }

}