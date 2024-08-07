package ski.jeff.zergski

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import ski.jeff.zergski.apps.hivemanagementapp.HiveManagementApp
import ski.jeff.zergski.apps.hiveunitapp.HiveUnitListApp
import ski.jeff.zergski.ui.theme.ZergskiTheme
import ski.jeff.zergski.apps.unitsearch.UnitSearchAppWithNavigation

enum class APP_MODES {
    HIVE_UNIT_LIST,
    UNIT_SEARCH,
    HIVE_MANAGEMENT
}

class MainMostActivity : ComponentActivity() {
    companion object {
        val CURRENT_APP_MODE = APP_MODES.HIVE_UNIT_LIST
    }

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZergskiTheme {
                when (CURRENT_APP_MODE) {
                    APP_MODES.HIVE_UNIT_LIST -> {
                        HiveUnitListApp()
                    }
                    APP_MODES.UNIT_SEARCH -> {
                        UnitSearchAppWithNavigation(calculateWindowSizeClass(activity = this))
                    }
                    APP_MODES.HIVE_MANAGEMENT -> {
                        HiveManagementApp()
                    }
                }

            }
        }
    }
}


