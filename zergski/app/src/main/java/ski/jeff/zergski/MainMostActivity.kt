package ski.jeff.zergski

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.ui.theme.ZergskiTheme

class MainMostActivity : ComponentActivity() {
    companion object {
        val creatureList = mutableListOf(
            HiveCreatureInformation("Zergling", R.drawable.unit_zergling, R.string.zergling_unit_contDesc, "Zerglings form the most numerous of the zerg mutations,—their simple DNA (distilled from the dune runners' genetic code to its most simple form) allows two zerglings to be spawned from a single larva. The larvae get the genetic information from the 'primordial ooze' of spawning pools. Zergling replication is so efficient that they thrive even when exposed to exceedingly high mortality rates, which are greater than almost all other zerg strains. While their core DNA comes from the dune runner, zerglings are hybridized from over fifteen other organism strains."),
            HiveCreatureInformation("Hydralisk", R.drawable.unit_hydralisk, R.string.hydralisk_unit_contDesc, "The hydralisk is a zerg evolution of the slothien, combined with seven or eight distinct and diverse organism strains. While slothiens were peaceful herbivores, the hydralisk is noted as being one of the most fierce and sadistic of the zerg strains. Hydralisks are a versatile combat strain, and form the backbone of the Swarm, acting as shock troops. To terrans, hydralisks symbolize the Swarm's power more than any other strain."),
            HiveCreatureInformation("Mutalisk", R.drawable.unit_mutalisk, R.string.hydralisk_unit_contDesc, "The mutalisk's attack strikes three targets in succession, dealing 9 damage to the first, 3 to the second, and 1 to the last. Unlike many other air units, the mutalisk is small with light-type armor, making it more resistant to explosive damage, a common damage type found on anti-air units like dragoons and goliath. The mutalisk deals normal damage and is only affected by the armor of the target. Compared to the wraith and scout, the mutalisk's attack is weaker and more easily affected by armor."),
            HiveCreatureInformation("Overlord", R.drawable.unit_overlord, R.string.overlord_unit_contDesc, "The overlord is a versatile zerg flyer that provides control, detection and air transportation once upgraded. It is slower than other transport units even with Pneumatized Carapace. As they provide supply, overlords are also vulnerable targets to hit-and-run air units such as wraiths, corsairs, mutalisks and scouts."),
        )


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for(i in 0..100) {
            creatureList.add(creatureList[0])
        }
        setContent {
            ZergskiApp(creatureList)
        }
    }
}

@Composable
fun ZergskiApp(creaturesList: List<HiveCreatureInformation> = listOf()) {
    var isShowingWelcome by rememberSaveable { mutableStateOf(true) }

    val backgroundColor = if(isSystemInDarkTheme()) {
        println("jeffski dark mode")
        Color(0,0,0)
    }
    else {
        println("jeffski light mode")
        Color(255, 255, 255, 255)
    }
    ZergskiTheme {
        Surface {
            if(isShowingWelcome) {
                WelcomeToZergski(onStartClicked = {isShowingWelcome = !isShowingWelcome})
            }
            else {
                Column(modifier = Modifier.background(color = backgroundColor).fillMaxSize()) {
                    Button(onClick = {isShowingWelcome = !isShowingWelcome}) {
                        Text("Home")
                    }
                    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
                        items(items = creaturesList) { nextCreature ->
                            HiveCreatureInfoCard(nextCreature)
                        }
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