package ski.jeff.zergski.apps.unitsearch

import ski.jeff.zergski.R

class Building(val name: String, val iconId: Int) {
}

class BuildingListProvider() {
    companion object {
        val previewList = listOf(
            Building("Hatchery", R.drawable.building_hatchery),
            Building("Spawningpool", R.drawable.building_spawningpool),
            Building("Evolutionchamber", R.drawable.building_evolutionchamber),
            Building("Spire", R.drawable.building_spire),
            Building("Lair", R.drawable.building_lair),
            Building("Hive", R.drawable.building_hive),
        )
        val previewInfo = previewList.first()
        fun getList(): List<Building> {
            return previewList
        }
    }
}