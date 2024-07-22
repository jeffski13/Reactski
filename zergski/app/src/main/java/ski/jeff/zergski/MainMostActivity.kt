package ski.jeff.zergski

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.ui.theme.ZergskiTheme

class MainMostActivity : ComponentActivity() {
    companion object {
        val creatureList = listOf(
//            CreatureFile("Zergling", R.drawable.unit_zergling, R.string.zergling_unit_contDesc, "Zerglings form the most numerous of the zerg mutations,—their simple DNA (distilled from the dune runners' genetic code to its most simple form) allows two zerglings to be spawned from a single larva. The larvae get the genetic information from the 'primordial ooze' of spawning pools. Zergling replication is so efficient that they thrive even when exposed to exceedingly high mortality rates, which are greater than almost all other zerg strains. While their core DNA comes from the dune runner, zerglings are hybridized from over fifteen other organism strains."),
//            CreatureFile("Hydralisk", R.drawable.unit_hydralisk, R.string.hydralisk_unit_contDesc, "The hydralisk is a zerg evolution of the slothien, combined with seven or eight distinct and diverse organism strains. While slothiens were peaceful herbivores, the hydralisk is noted as being one of the most fierce and sadistic of the zerg strains. Hydralisks are a versatile combat strain, and form the backbone of the Swarm, acting as shock troops. To terrans, hydralisks symbolize the Swarm's power more than any other strain."),
            CreatureFile("Mutalisk", R.drawable.unit_mutalisk, R.string.hydralisk_unit_contDesc, "")
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyZergskiApp(creatureList)
        }
    }
}

@Composable
fun MyZergskiApp(creaturesList: List<CreatureFile> = listOf()) {
    var isShowingWelcome by remember { mutableStateOf(true) }

    if(isShowingWelcome) {
        WelcomeToZergski()
    }
    else {
        ZergskiTheme {
            Surface(color = MaterialTheme.colorScheme.background) {
                Column {
                    for(nextCreature in creaturesList){
                        Greeting(nextCreature)
                    }
                }
            }
        }
    }
}

/**
 * thie needs to be called within the [setContent]
 */
@Composable
fun Greeting(creatureFile: CreatureFile) {
    var isShowingInfo by remember { mutableStateOf(true) }
    val extraRoomskiBelow = if(isShowingInfo) {
        20.dp
    }
    else {
        0.dp
    }
    Surface(color = Color(13, 49, 139, 255),
        modifier = Modifier.padding(4.dp)) {
        Row (modifier = Modifier.padding(0.dp, 0.dp, 0.dp,  extraRoomskiBelow)) {
            Column (modifier = Modifier.weight(1f)) {
                Image(
                    painter = painterResource(id = creatureFile.unitImage),
                    contentDescription = stringResource(id = creatureFile.unitImageContentDescriptionStringId),
                    modifier = Modifier.size(100.dp)

                )

            }
            Column (modifier = Modifier
                .weight(1f)
                .padding(0.dp, 0.dp, 0.dp, extraRoomskiBelow)
                .fillMaxWidth(),) {
                Text(
                    text = creatureFile.name,
                    color = Color.White,
                    modifier = Modifier
                        .padding(20.dp, 5.dp),
                )
                ElevatedButton(onClick = {isShowingInfo = !isShowingInfo}) {
                    Text(if(!isShowingInfo) "wannaSeeMo?" else "getOuttaHere")
                }
            }
        }
        Row (modifier = Modifier.padding(10.dp, 60.dp, 10.dp)) {
            if(isShowingInfo) {
                Column {
                    Text(
                        text = creatureFile.info,
                        color = Color.White,
                        modifier = Modifier
                            .padding(20.dp, 5.dp)
                            .fillMaxWidth(),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun AnyNameSki() {
    ZergskiTheme {
        MyZergskiApp(MainMostActivity.creatureList)
    }
}

class CreatureFile(val name: String, val unitImage: Int, val unitImageContentDescriptionStringId: Int, val info: String)