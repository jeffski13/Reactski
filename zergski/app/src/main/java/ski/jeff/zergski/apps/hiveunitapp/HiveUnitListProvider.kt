package ski.jeff.zergski.apps.hiveunitapp

import ski.jeff.zergski.R

class HiveUnitListProvider() {
    companion object {
        val CREATURE_LIST = mutableListOf(
            HiveUnitInformation("Overlord",
                R.drawable.unit_overlord,
                R.string.overlord_unit_contDesc,
                "The overlord is a versatile zerg flyer that provides control, detection and air transportation once upgraded. It is slower than other transport units even with Pneumatized Carapace. As they provide supply, overlords are also vulnerable targets to hit-and-run air units such as wraiths, corsairs, mutalisks and scouts."),
            HiveUnitInformation("Drone",
                R.drawable.unit_drone,
                R.string.drone_unit_contDesc,
                "Drones mutate into the buildings they construct. The only way to stop a building from completing is to destroy it or to cancel it; in the latter event the drone is recovered and may be used for some other purpose. Once the building is complete the drone is unrecoverable."),
            HiveUnitInformation("Zergling",
                R.drawable.unit_zergling,
                R.string.zergling_unit_contDesc,
                "Zerglings form the most numerous of the zerg mutations,—their simple DNA (distilled from the dune runners' genetic code to its most simple form) allows two zerglings to be spawned from a single larva. The larvae get the genetic information from the 'primordial ooze' of spawning pools. Zergling replication is so efficient that they thrive even when exposed to exceedingly high mortality rates, which are greater than almost all other zerg strains. While their core DNA comes from the dune runner, zerglings are hybridized from over fifteen other organism strains."),
            HiveUnitInformation("Hydralisk",
                R.drawable.unit_hydralisk,
                R.string.hydralisk_unit_contDesc,
                "The hydralisk is a zerg evolution of the slothien, combined with seven or eight distinct and diverse organism strains. While slothiens were peaceful herbivores, the hydralisk is noted as being one of the most fierce and sadistic of the zerg strains. Hydralisks are a versatile combat strain, and form the backbone of the Swarm, acting as shock troops. To terrans, hydralisks symbolize the Swarm's power more than any other strain."),
            HiveUnitInformation("Infested Terran",
                R.drawable.unit_infestedterran,
                R.string.infestedterran_unit_contDesc,
                "The infested terran is a unit in StarCraft II created by an infestor. It is often referred to as the infested marine. It was removed from Versus in Patch 4.11."),
            HiveUnitInformation("Mutalisk",
                R.drawable.unit_mutalisk,
                R.string.mutalisk_unit_contDesc,
                "The mutalisk's attack strikes three targets in succession, dealing 9 damage to the first, 3 to the second, and 1 to the last. Unlike many other air units, the mutalisk is small with light-type armor, making it more resistant to explosive damage, a common damage type found on anti-air units like dragoons and goliath. The mutalisk deals normal damage and is only affected by the armor of the target. Compared to the wraith and scout, the mutalisk's attack is weaker and more easily affected by armor."),
            HiveUnitInformation("Guardian",
                R.drawable.unit_guardian,
                R.string.guardian_unit_contDesc,
                "The guardian is converted from an existing mutalisk. It has an anti-ground attack that out-ranges almost all ground-to-air weapons, and in large groups can be particularly devastating as a bomber unit. While the guardian has a respectable attack of 20 (26 when fully upgraded), it has no defense against enemy air units and is vulnerable to ground-to-air units when on the run. The slow speed of the guardian also renders it vulnerable to area-of-effect spells such as psionic storm and irradiate, or long range anti-air units."),
            HiveUnitInformation("Scourge",
                R.drawable.unit_scourge,
                R.string.scourge_unit_contDesc,
                "Scourges spawn in pairs. Patrolling scourges may help deter low intensity enemy drops. Without supervision groups of scourges tend to lock onto and attack the first target that comes into range which may be overkill against low-HP targets (causing scourges to sacrifice themselves needlessly). Using other units to draw enemy fire may allow scourge to hit. Scourges are useful against carriers; it only takes five of them to down one carrier."),
            HiveUnitInformation("Devourer",
                R.drawable.unit_devourer,
                R.string.devourer_unit_contDesc,
                "Devourers are an evolution of the mutalisk,[1] but have a wasp-like form, and are much larger, slower, but more durable.[2] They retain the mutalisk's signature tail,[2] from which they spit a venom of corrosive acid at aerial targets that can eat through the reinforced armor plating of terran and protoss capital ships.[1] The initial damage these globs inflict is not insignificant, but as spores build up on targets, they will eat through hull plating on the molecular level, making it easier for other attacks to penetrate ship armor.[2] A single spit of venom may splash over multiple targets.[1] The acid spores in the venom may hinder the fighting ability of the target,[3] such as reducing an enemy ship's speed,[2] and will reveal cloaked units.[2] Generally, devourers fly in packs.[4]"),
        )
    }

    fun getUnitInfoCardDataList(): List<HiveUnitInfoCardData> {
        val hiveUnitInfoCardDataList = mutableListOf<HiveUnitInfoCardData>()
        for(i in 0..100) {
            val hiveCreatureInformation = if(i < CREATURE_LIST.size) {
                CREATURE_LIST[i]
            }
            else {
                CREATURE_LIST[i - (((i/ CREATURE_LIST.size)* CREATURE_LIST.size)).coerceAtLeast(0)]
            }
            hiveUnitInfoCardDataList.add(HiveUnitInfoCardData(hiveCreatureInformation, (i + 1)))
        }
        return hiveUnitInfoCardDataList
    }

    fun getPreviewList(): List<HiveUnitInfoCardData> {
        val hiveUnitInfoCardDataList = mutableListOf<HiveUnitInfoCardData>()
        hiveUnitInfoCardDataList.add(HiveUnitInfoCardData(CREATURE_LIST[0], 0))
        return hiveUnitInfoCardDataList
    }
}