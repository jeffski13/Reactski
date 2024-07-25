package ski.jeff.zergski.apps.unitsearch

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
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
import ski.jeff.zergski.apps.hivecreatureapp.HiveCreatureListProvider

@Composable
fun FavoriteUnitCard(favoriteUnitCardInfo: FavoriteUnitCardInfo, modifier: Modifier = Modifier) {
    Surface(modifier = modifier, shape = RoundedCornerShape(8.dp)) {
        Column(modifier = Modifier.width(255.dp)){
            Row (verticalAlignment = Alignment.CenterVertically){
               Image(
                   painterResource(id = favoriteUnitCardInfo.iconId),
                   contentDescription = null,
                   modifier = Modifier.heightIn(min = 80.dp),
                   contentScale = ContentScale.Crop
               )
               Text(favoriteUnitCardInfo.name,
                   modifier = Modifier.padding(horizontal = 16.dp),
                   style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

class FavoriteUnitCardInfo(val name: String, @DrawableRes val iconId: Int) {
    companion object {
        val previewData = FavoriteUnitCardInfo(HiveCreatureListProvider.CREATURE_LIST[0].name, HiveCreatureListProvider.CREATURE_LIST[0].unitImage)
    }
}

@Preview
@Composable
fun previewFavoriteUnitCard() {
    FavoriteUnitCard(favoriteUnitCardInfo = FavoriteUnitCardInfo.previewData)
}