package ski.jeff.zergski.apps.hiveunitapp

import androidx.compose.runtime.mutableStateOf
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

