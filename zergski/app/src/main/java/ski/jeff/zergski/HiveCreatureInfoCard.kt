package ski.jeff.zergski

import android.content.res.Configuration
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
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.ui.theme.ZergskiTheme

class HiveCreatureInfoCardData(val hiveCreatureInformation: HiveCreatureInformation, val index: Int)

/**
 * thie needs to be called within the [setContent]
 */
@Composable
fun HiveCreatureInfoCard(hiveCreatureInfoCardData: HiveCreatureInfoCardData) {
    val hiveCreatureInformation = hiveCreatureInfoCardData.hiveCreatureInformation
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

    Surface(modifier = Modifier.padding(4.dp)) {
        Column {

            Row(modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, extraRoomskiBelow.coerceAtLeast(0.dp))
                .clickable { isShowingInfo = !isShowingInfo },
                verticalAlignment = Alignment.CenterVertically,
                ) {
                Column(modifier = Modifier.weight(0.35f)) {
                    Image(painter = painterResource(id = hiveCreatureInformation.unitImage),
                        contentDescription = stringResource(id = hiveCreatureInformation.unitImageContentDescriptionStringId),
                        modifier = Modifier
                            .size(100.dp)
                            .padding(2.dp)
                    )

                }
                Column(
                    modifier = Modifier
                        .weight(0.65f)
                        .fillMaxWidth()

                ) {
                    Text(
                        text = hiveCreatureInformation.name,
                        modifier = Modifier.padding(20.dp, 5.dp),
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Order: ${hiveCreatureInfoCardData.index.toString()}",
                        modifier = Modifier.padding(20.dp, 5.dp),
                    )
                }
                Column {
                    Button(onClick = { isShowingInfo = !isShowingInfo }, contentPadding = PaddingValues(8.dp)) {
                        Text(moreInfoButtonText)
                    }
                }
            }
            Row(modifier = Modifier
                .padding(10.dp, 0.dp)) {
                if (isShowingInfo) {
                    Column (modifier = Modifier.clickable { isShowingInfo = !isShowingInfo },) {
                        Text(
                            text = hiveCreatureInformation.info,
                            modifier = Modifier
                                .padding(20.dp, 5.dp, 20.dp, 20.dp,)
                        )
                    }
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun previewHiveCreatureInfoCard() {
    ZergskiTheme {
        HiveCreatureInfoCard(HiveCreatureInfoCardData(MainMostActivity.creatureListSource[0], 0))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun previewHiveCreatureInfoCarddarkMode() {
    ZergskiTheme {
        HiveCreatureInfoCard(HiveCreatureInfoCardData(MainMostActivity.creatureListSource[0], 0))
    }
}