package ski.jeff.zergski

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import ski.jeff.zergski.ui.theme.ZergskiTheme

class MainMostActivity : ComponentActivity() {
    companion object {
        val creatureList = listOf(
            HiveCreatureInformation("Zergling", R.drawable.unit_zergling, R.string.zergling_unit_contDesc, "Zerglings form the most numerous of the zerg mutations,—their simple DNA (distilled from the dune runners' genetic code to its most simple form) allows two zerglings to be spawned from a single larva. The larvae get the genetic information from the 'primordial ooze' of spawning pools. Zergling replication is so efficient that they thrive even when exposed to exceedingly high mortality rates, which are greater than almost all other zerg strains. While their core DNA comes from the dune runner, zerglings are hybridized from over fifteen other organism strains."),
            HiveCreatureInformation("Hydralisk", R.drawable.unit_hydralisk, R.string.hydralisk_unit_contDesc, "The hydralisk is a zerg evolution of the slothien, combined with seven or eight distinct and diverse organism strains. While slothiens were peaceful herbivores, the hydralisk is noted as being one of the most fierce and sadistic of the zerg strains. Hydralisks are a versatile combat strain, and form the backbone of the Swarm, acting as shock troops. To terrans, hydralisks symbolize the Swarm's power more than any other strain."),
            HiveCreatureInformation("Mutalisk", R.drawable.unit_mutalisk, R.string.hydralisk_unit_contDesc, "")
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZergskiApp(creatureList)
        }
    }
}

@Composable
fun ZergskiApp(creaturesList: List<HiveCreatureInformation> = listOf()) {
    var isShowingWelcome by remember { mutableStateOf(true) }

    ZergskiTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            if(isShowingWelcome) {
                WelcomeToZergski(onStartClicked = {isShowingWelcome = !isShowingWelcome})
            }
            else {
                Column {
                    Button(onClick = {isShowingWelcome = !isShowingWelcome}) {
                        Text("Home")
                    }
                    for(nextCreature in creaturesList){
                        HiveCreatureInfoCard(nextCreature)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 415, heightDp = 820)
@Composable
fun AnyNameSki() {
    ZergskiTheme {
        ZergskiApp(MainMostActivity.creatureList)
    }
}