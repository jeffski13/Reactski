package ski.jeff.zergski

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import ski.jeff.zergski.apps.basemanagementapp.BaseManagementApp
import ski.jeff.zergski.apps.hivecreatureapp.HiveCreatureListProvider
import ski.jeff.zergski.apps.hivecreatureapp.HiveCreaureListApp
import ski.jeff.zergski.ui.theme.ZergskiTheme
import ski.jeff.zergski.apps.unitsearch.UnitSearchAppWithNavigation

enum class APP_MODES {
    HIVE_CREATURE_LIST,
    UNIT_SEARCH,
    BASE_MANAGEMENT
}

class MainMostActivity : ComponentActivity() {
    companion object {
        val CURRENT_APP_MODE = APP_MODES.BASE_MANAGEMENT
    }

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZergskiTheme {
                when (CURRENT_APP_MODE) {
                    APP_MODES.HIVE_CREATURE_LIST -> {
                        HiveCreaureListApp(HiveCreatureListProvider().getCreatureInfoCardDataList())
                    }
                    APP_MODES.UNIT_SEARCH -> {
                        UnitSearchAppWithNavigation(calculateWindowSizeClass(activity = this))
                    }
                    APP_MODES.BASE_MANAGEMENT -> {
                        BaseManagementApp()
                    }
                }

            }
        }
    }
}


