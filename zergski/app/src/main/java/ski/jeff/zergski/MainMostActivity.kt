package ski.jeff.zergski

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import ski.jeff.zergski.hivecreatureapp.HiveCreatureListProvider
import ski.jeff.zergski.hivecreatureapp.HiveCreaureListApp
import ski.jeff.zergski.ui.theme.ZergskiTheme
import ski.jeff.zergski.unitsearch.UnitSearchApp

enum class APP_MODES {
    HIVE_CREATURE_LIST,
    UNIT_SEARCH
}

class MainMostActivity : ComponentActivity() {
    companion object {
        val CURRENT_APP_MODE = APP_MODES.HIVE_CREATURE_LIST
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZergskiTheme {
                when (CURRENT_APP_MODE) {
                    APP_MODES.HIVE_CREATURE_LIST -> {
                        HiveCreaureListApp(HiveCreatureListProvider().getCreatureInfoCardDataList())
                    }
                    APP_MODES.UNIT_SEARCH -> {
                        UnitSearchApp()
                    }
                    else -> {
                        Text("APPMODE: ${CURRENT_APP_MODE.name}")
                    }
                }

            }
        }
    }
}
