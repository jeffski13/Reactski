package ski.jeff.zergski.apps.hiveunitapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class HiveUnitInfoCardData(val hiveUnitInformation: HiveUnitInformation, val index: Int) {
    companion object {
        const val DROPDOWN_CONT_DESC_COLLAPSED = "more please"
        const val DROPDOWN_CONT_DESC_EXPANDED = "less please"
    }

    private val _isShowingInfo = mutableStateOf(false)
    val isShowingInfo: State<Boolean> = _isShowingInfo

    private val _extraRoomskiBelowHeight = mutableStateOf(0.dp)
    val extraRoomskiBelowHeight: State<Dp> = _extraRoomskiBelowHeight

    var iconLook: ImageVector = Icons.Filled.ExpandMore

    var dropdownContentDescription: String = DROPDOWN_CONT_DESC_COLLAPSED

    init {
        updateStateForIsShowing()
    }

    fun onIsShowingToggle() {
        _isShowingInfo.value = !isShowingInfo.value
        updateStateForIsShowing()
    }

    private fun updateStateForIsShowing() {
        if(isShowingInfo.value) {
            _extraRoomskiBelowHeight.value = 10.dp
            iconLook = Icons.Filled.ExpandLess
            dropdownContentDescription = DROPDOWN_CONT_DESC_EXPANDED
        }
        else {
            _extraRoomskiBelowHeight.value = 0.dp
            iconLook = Icons.Filled.ExpandMore
            dropdownContentDescription = DROPDOWN_CONT_DESC_COLLAPSED
        }
    }

}