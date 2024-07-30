package ski.jeff.zergski.apps.basemanagementapp

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun NumberOfDrones(modifier: Modifier = Modifier){
    var dronesHatched = 0
    Column {
        Text("Drones Created: $dronesHatched", modifier = modifier.padding(16.dp))
        Button(onClick = {dronesHatched++}) {
            Text("spawn drone")
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewNumberOfDrones() {
    NumberOfDrones()
}