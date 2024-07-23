package ski.jeff.zergski

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * thie needs to be called within the [setContent]
 */
@Composable
fun HiveCreatureInfoCard(hiveCreatureInformation: HiveCreatureInformation) {
    var isShowingInfo by rememberSaveable { mutableStateOf(false) }
    val extraRoomskiBelowHeight = if(isShowingInfo) {
        10.dp
    }
    else {
        0.dp
    }
    val extraRoomskiBelow by animateDpAsState(extraRoomskiBelowHeight,
        spring(dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow),
        "some label??? for animation?")

    val moreInfoButtonText = if(!isShowingInfo) {
        "wannaSeeMo?"
    } else {
        "getOuttaHere"
    }

    Surface(color = Color(54, 11, 102, 255), modifier = Modifier.padding(4.dp)) {
        Column {

            Row(modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, extraRoomskiBelow.coerceAtLeast(0.dp))
                .clickable { isShowingInfo = !isShowingInfo },
                verticalAlignment = Alignment.CenterVertically,
                ) {
                Column(modifier = Modifier.weight(1f)) {
                    Image(painter = painterResource(id = hiveCreatureInformation.unitImage),
                        contentDescription = stringResource(id = hiveCreatureInformation.unitImageContentDescriptionStringId),
                        modifier = Modifier
                            .size(100.dp)
                            .padding(2.dp)
                    )

                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = hiveCreatureInformation.name,
                        color = Color.White,
                        modifier = Modifier.padding(20.dp, 5.dp),
                    )
                }
                Column {
                    ElevatedButton(onClick = { isShowingInfo = !isShowingInfo }, contentPadding = PaddingValues(8.dp)) {
                        Text(moreInfoButtonText)
                    }
                }
            }
            Row(modifier = Modifier
                .padding(10.dp, 0.dp)) {
                if (isShowingInfo) {
                    Column {
                        Text(
                            text = hiveCreatureInformation.info,
                            color = Color.White,
                            modifier = Modifier
                                .padding(20.dp, 5.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun previewHiveCreatureInfoCard() {
    HiveCreatureInfoCard(MainMostActivity.creatureList[0])
}