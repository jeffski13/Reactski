package ski.jeff.zergski.apps.unitsearch

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DensitySmall
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.ui.theme.ZergskiTheme

class UnitSearchBottomNavigation {
    companion object {
        val BOTTOM_NAVIGATION_HOME_ICON = Icons.Default.DensitySmall
        const val BOTTOM_NAVIGATION_HOME_TITLE = "Home"
        val BOTTOM_NAVIGATION_ACCOUNT_ICON = Icons.Default.AccountBox
        const val BOTTOM_NAVIGATION_ACCOUNT_TITLE = "Account"
    }
}

@Composable
fun UnitSearchBottomNavigationPortrait(modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier, containerColor = MaterialTheme.colorScheme.surfaceVariant) {
        NavigationBarItem(selected = true, onClick = {}, label = {
            Text(text = UnitSearchBottomNavigation.BOTTOM_NAVIGATION_HOME_TITLE)
        }, icon = {
            Icon(imageVector = UnitSearchBottomNavigation.BOTTOM_NAVIGATION_HOME_ICON, contentDescription = null)
        })
        NavigationBarItem(selected = false, onClick = {}, label = {
            Text(text = UnitSearchBottomNavigation.BOTTOM_NAVIGATION_ACCOUNT_TITLE)
        }, icon = {
            Icon(imageVector = UnitSearchBottomNavigation.BOTTOM_NAVIGATION_ACCOUNT_ICON, contentDescription = null)
        })
    }
}


@Composable
fun UnitSearchAppNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(modifier = modifier) {
        Column (modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(selected = true, onClick = {}, label = {
                Text(text = UnitSearchBottomNavigation.BOTTOM_NAVIGATION_HOME_TITLE)
            }, icon = {
                Icon(imageVector = UnitSearchBottomNavigation.BOTTOM_NAVIGATION_HOME_ICON, contentDescription = null)
            })
            NavigationRailItem(selected = false, onClick = {}, label = {
                Text(text = UnitSearchBottomNavigation.BOTTOM_NAVIGATION_ACCOUNT_TITLE)
            }, icon = {
                Icon(imageVector = UnitSearchBottomNavigation.BOTTOM_NAVIGATION_ACCOUNT_ICON, contentDescription = null)
            })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun previewUnitSearchAppNavigationRail() {
    ZergskiTheme {
        UnitSearchAppNavigationRail()
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun previewUnitSearchAppNavigationRailDarkMode() {
    ZergskiTheme {
        UnitSearchAppNavigationRail()
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun previewUnitSearchBottomNavigation() {
    ZergskiTheme {
        UnitSearchBottomNavigation()
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun previewUnitSearchBottomNavigationDarkMode() {
    ZergskiTheme {
        UnitSearchBottomNavigation()
    }
}