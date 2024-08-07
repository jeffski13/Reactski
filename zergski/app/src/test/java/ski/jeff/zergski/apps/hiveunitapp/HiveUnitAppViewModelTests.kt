package ski.jeff.zergski.apps.hiveunitapp

import org.junit.Test

import org.junit.Assert.*
import ski.jeff.zergski.apps.hivemanagementapp.tasks.TaskManagerViewModel

class HiveUnitAppViewModelTests {
    @Test
    fun `Home screen showing on startup`() {
        val hiveUnitAppViewModel = HiveUnitAppViewModel()
        assertEquals(true, hiveUnitAppViewModel.isShowingWelcome.value)
    }

    @Test
    fun `Home screen goes away on start clicked`() {
        val hiveUnitAppViewModel = HiveUnitAppViewModel()
        hiveUnitAppViewModel.onStartClicked()
        assertEquals(false, hiveUnitAppViewModel.isShowingWelcome.value)
    }

    @Test
    fun `Home screen reappears after start clicked`() {
        val hiveUnitAppViewModel = HiveUnitAppViewModel()
        hiveUnitAppViewModel.onStartClicked()
        hiveUnitAppViewModel.onHomeClicked()
        assertEquals(true, hiveUnitAppViewModel.isShowingWelcome.value)
    }

    @Test
    fun `units start collapsed`() {
        val hiveUnitAppViewModel = HiveUnitAppViewModel()
        hiveUnitAppViewModel.hiveUnitInfoCardDataList.forEach {
            assertEquals(false, it.isShowingInfo.value)
            assertEquals(HiveUnitInfoCardData.DROPDOWN_CONT_DESC_COLLAPSED, it.dropdownContentDescription)
        }
    }

    @Test
    fun `expanding one unit changes expansion state`() {
        val hiveUnitAppViewModel = HiveUnitAppViewModel()
        hiveUnitAppViewModel.hiveUnitInfoCardDataList[0].onIsShowingToggle()
        assertEquals(true, hiveUnitAppViewModel.hiveUnitInfoCardDataList[0].isShowingInfo.value)
        assertEquals(HiveUnitInfoCardData.DROPDOWN_CONT_DESC_EXPANDED, hiveUnitAppViewModel.hiveUnitInfoCardDataList[0].dropdownContentDescription)
    }

    @Test
    fun `expanding one unit does not expand others`() {
        val hiveUnitAppViewModel = HiveUnitAppViewModel()
        hiveUnitAppViewModel.hiveUnitInfoCardDataList[0].onIsShowingToggle()
        hiveUnitAppViewModel.hiveUnitInfoCardDataList.forEach {
            if(it.index != 1) {
                assertEquals(false, it.isShowingInfo.value)
            }
        }
    }
}