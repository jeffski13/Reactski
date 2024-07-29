package ski.jeff.zergski.apps.unitsearch

import androidx.annotation.DrawableRes
import ski.jeff.zergski.apps.hivecreatureapp.HiveCreatureListProvider

class FavoriteUnitCardInfo(val name: String, @DrawableRes val iconId: Int) {
}

class FavoriteUnitCardInfoListProvider() {
    companion object {

        fun getList(): List<FavoriteUnitCardInfo> {
            val list = mutableListOf<FavoriteUnitCardInfo>()
            HiveCreatureListProvider.CREATURE_LIST.forEach {
                list.add(FavoriteUnitCardInfo(it.name, it.unitImage))
            }
            return list
        }

        val PREVIEW_DATA = getList()[3]
    }


}