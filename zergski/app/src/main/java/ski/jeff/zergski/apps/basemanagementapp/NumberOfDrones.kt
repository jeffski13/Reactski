package ski.jeff.zergski.apps.basemanagementapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NumberOfDrones(modifier: Modifier = Modifier){
    var dronesHatched = rememberSaveable { mutableStateOf(0) }
    Column {
        Button(onClick = {dronesHatched.value++}, enabled = (dronesHatched.value < 5)) {
            Text("spawn drone")
        }
        if(dronesHatched.value > 0) {
            Text("Drones Created: ${dronesHatched.value}", modifier = modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewNumberOfDrones() {
    NumberOfDrones()
}