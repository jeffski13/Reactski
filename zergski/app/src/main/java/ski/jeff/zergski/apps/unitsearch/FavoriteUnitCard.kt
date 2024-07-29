package ski.jeff.zergski.apps.unitsearch

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun FavoriteUnitCard(favoriteUnitCardInfo: FavoriteUnitCardInfo, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(modifier = Modifier.width(255.dp)){
            Row (verticalAlignment = Alignment.CenterVertically){
               Image(
                   painterResource(id = favoriteUnitCardInfo.iconId),
                   contentDescription = null,
                   modifier = Modifier.size(80.dp),
                   contentScale = ContentScale.Crop
               )
               Text(favoriteUnitCardInfo.name,
                   color = MaterialTheme.colorScheme.onSurface,
                   modifier = Modifier.padding(horizontal = 16.dp),
                   style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun previewFavoriteUnitCard() {
    ZergskiTheme {
        FavoriteUnitCard(favoriteUnitCardInfo = FavoriteUnitCardInfoListProvider.PREVIEW_DATA)
    }
}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun previewFavoriteUnitCardDarkMode() {
    ZergskiTheme {
        FavoriteUnitCard(favoriteUnitCardInfo = FavoriteUnitCardInfoListProvider.PREVIEW_DATA)
    }
}