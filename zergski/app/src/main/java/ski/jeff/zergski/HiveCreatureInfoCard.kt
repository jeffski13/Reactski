package ski.jeff.zergski

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

/**
 * thie needs to be called within the [setContent]
 */
@Composable
fun HiveCreatureInfoCard(hiveCreatureInformation: HiveCreatureInformation) {
    var isShowingInfo by remember { mutableStateOf(false) }
    val extraRoomskiBelow = if(isShowingInfo) {
        20.dp
    }
    else {
        0.dp
    }

    val moreInfoButtonText = if(!isShowingInfo) "wannaSeeMo?" else "getOuttaHere"
    Surface(color = Color(13, 49, 139, 255), modifier = Modifier.padding(4.dp)) {
        Row(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, extraRoomskiBelow)) {
            Column(modifier = Modifier.weight(1f)) {
                Image(painter = painterResource(id = hiveCreatureInformation.unitImage),
                    contentDescription = stringResource(id = hiveCreatureInformation.unitImageContentDescriptionStringId),
                    modifier = Modifier.size(100.dp)

                )

            }
            Column(
                modifier = Modifier.weight(1f).padding(0.dp, 0.dp, 0.dp, extraRoomskiBelow).fillMaxWidth(),
            ) {
                Text(
                    text = hiveCreatureInformation.name,
                    color = Color.White,
                    modifier = Modifier.padding(20.dp, 5.dp),
                )
                ElevatedButton(onClick = { isShowingInfo = !isShowingInfo }, contentPadding = PaddingValues(0.dp)) {
                    Text(moreInfoButtonText)

                }
            }
        }
        Row(modifier = Modifier.padding(10.dp, 60.dp, 10.dp)) {
            if (isShowingInfo) {
                Column {
                    Text(
                        text = hiveCreatureInformation.info,
                        color = Color.White,
                        modifier = Modifier.padding(20.dp, 5.dp).fillMaxWidth(),
                    )
                }
            }
        }
    }
}