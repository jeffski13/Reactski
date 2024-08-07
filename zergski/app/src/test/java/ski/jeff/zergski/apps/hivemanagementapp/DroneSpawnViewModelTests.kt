package ski.jeff.zergski.apps.hivemanagementapp

import org.junit.Test

import org.junit.Assert.*
import ski.jeff.zergski.apps.hivemanagementapp.dronespawn.DroneSpawnViewModel

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DroneSpawnViewModelTests {
    @Test
    fun `Drone count initialized correctly`() {
        val droneSpawnViewModel = DroneSpawnViewModel()
        assertEquals(false, droneSpawnViewModel.isDroneCountShowing)
        assertEquals(true, droneSpawnViewModel.isAddDroneEnabled)
    }

    @Test
    fun `Drone stops showing after spawn`() {
        val droneSpawnViewModel = DroneSpawnViewModel()
        droneSpawnViewModel.spawnDrone()
        assertEquals(true, droneSpawnViewModel.isDroneCountShowing)
    }

    @Test
    fun `Drone spawn disabled showing after 5`() {
        val droneSpawnViewModel = DroneSpawnViewModel()
        for(i in 0..10) {
            droneSpawnViewModel.spawnDrone()
        }
        assertEquals(true, droneSpawnViewModel.isDroneCountShowing)
        assertEquals(false, droneSpawnViewModel.isAddDroneEnabled)
        assertEquals(5, droneSpawnViewModel.dronesHatched.value)
    }
}