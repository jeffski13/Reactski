package ski.jeff.zergski.apps.hiveunitapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class HiveUnitAppViewModel: ViewModel() {
    val hiveUnitInfoCardDataList: List<HiveUnitInfoCardData> = HiveUnitListProvider().getUnitInfoCardDataList()
    val isShowingWelcome = mutableStateOf(true)

    fun onStartClicked() {
        isShowingWelcome.value = false
    }

    fun onHomeClicked() {
        isShowingWelcome.value = true
    }
}

class HiveUnitInfoCardData(val hiveUnitInformation: HiveUnitInformation, val index: Int) {

    var isShowingInfo = mutableStateOf(false)
    var extraRoomskiBelowHeight = mutableStateOf(0.dp)
    var iconLook: ImageVector = Icons.Filled.ExpandMore
    var dropdownContentDescription: String = "more please"

    init {
        updateStateForIsShowing()
    }

    fun onIsShowingToggle() {
        isShowingInfo.value = !isShowingInfo.value
        updateStateForIsShowing()
    }

    private fun updateStateForIsShowing() {
        if(isShowingInfo.value) {
            extraRoomskiBelowHeight.value = 10.dp
            iconLook = Icons.Filled.ExpandLess
            dropdownContentDescription = "less please"
        }
        else {
            extraRoomskiBelowHeight.value = 0.dp
            iconLook = Icons.Filled.ExpandMore
            dropdownContentDescription = "more please"
        }
    }

}
