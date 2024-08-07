package ski.jeff.zergski.apps.hivemanagementapp.dronespawn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NumberOfDrones(dronesHatched: Int, onSpawnDrone: () -> Unit, isButtonEnabled: Boolean, isDroneCountShowing: Boolean,  modifier: Modifier = Modifier){
    Column {
        Button(onClick = onSpawnDrone, enabled = isButtonEnabled) {
            Text("spawn drone")
        }
        if(isDroneCountShowing) {
            Text("Drones Created: $dronesHatched", modifier = modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewNumberOfDrones() {
    NumberOfDrones(0, {}, false, false)
}