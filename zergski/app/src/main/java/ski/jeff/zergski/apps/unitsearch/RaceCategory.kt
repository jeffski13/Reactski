package ski.jeff.zergski.apps.unitsearch

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ski.jeff.zergski.R
import ski.jeff.zergski.ui.theme.ZergskiTheme

@Composable
fun RaceCategory(
    categoryName: String,
    @DrawableRes iconId: Int, modifier: Modifier = Modifier) {
    Column (modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .heightIn(min = 88.dp),
            painter = painterResource(id = iconId),
            contentScale = ContentScale.FillBounds,
            contentDescription = categoryName,
        )
        Text("Zerg",
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun previewRaceCategory() {
    ZergskiTheme {
        RaceCategory(Race.previewInfo.name, Race.previewInfo.iconId,
            Modifier.padding(8.dp))
    }
}

class Race(val name: String, val iconId: Int) {
    companion object {
        val previewInfo = Race("Zerg Units", R.drawable.category_zerg)
    }
}