package ski.jeff.zergski.apps.hiveunitapp

import android.content.res.Configuration
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import ski.jeff.zergski.ui.theme.ZergskiTheme

/**
 * thie needs to be called within the [setContent]
 */
@Composable
fun HiveUnitInfoCard(
    hiveUnitInfoCardData: HiveUnitInfoCardData,
) {

    val extraRoomskiBelow = animateDpAsState(hiveUnitInfoCardData.extraRoomskiBelowHeight.value,
        spring(dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow),
        "some label??? for animation?")

    Surface(modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(6.dp)) {
        Column {

            SelectionContainer {
                Row(modifier = Modifier
                    .padding(2.dp, 0.dp, 0.dp, extraRoomskiBelow.value.coerceAtLeast(0.dp))
                    .clickable { hiveUnitInfoCardData.onIsShowingToggle() },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(modifier = Modifier.weight(0.25f)) {
                        Image(painter = painterResource(id = hiveUnitInfoCardData.hiveUnitInformation.unitImage),
                            contentDescription = stringResource(id = hiveUnitInfoCardData.hiveUnitInformation.unitImageContentDescriptionStringId),
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                        )

                    }
                    Column(
                        modifier = Modifier
                            .weight(0.6f)
                            .fillMaxWidth()

                    ) {
                            Text(
                                text = hiveUnitInfoCardData.hiveUnitInformation.name,
                                modifier = Modifier.padding(20.dp, 5.dp),
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "Order: ${hiveUnitInfoCardData.index.toString()}",
                                modifier = Modifier.padding(20.dp, 5.dp),
                            )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.15f)

                    ) {
                        IconButton(onClick = { hiveUnitInfoCardData.onIsShowingToggle() }) {
                            Icon(
                                imageVector = hiveUnitInfoCardData.iconLook,
                                contentDescription = hiveUnitInfoCardData.dropdownContentDescription
                            )
                        }
                    }
                }
            }
            Row(modifier = Modifier
                .padding(10.dp, 0.dp)) {
                if (hiveUnitInfoCardData.isShowingInfo.value) {
                    Column (modifier = Modifier.clickable { hiveUnitInfoCardData.onIsShowingToggle() },) {
                        SelectionContainer {
                            Text(
                                text = hiveUnitInfoCardData.hiveUnitInformation.info,
                                modifier = Modifier
                                    .padding(20.dp, 5.dp, 20.dp, 20.dp,)
                            )
                        }
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
        HiveUnitInfoCard(HiveUnitInfoCardData(HiveUnitListProvider.CREATURE_LIST[0], 0))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun previewHiveCreatureInfoCarddarkMode() {
    ZergskiTheme {
        HiveUnitInfoCard(HiveUnitInfoCardData(HiveUnitListProvider.CREATURE_LIST[0], 0))
    }
}