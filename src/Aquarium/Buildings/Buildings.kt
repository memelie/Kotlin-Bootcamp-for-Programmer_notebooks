package Aquarium.Buildings

open class BaseBuildingMaterial() {
    open val numberNeeded = 1;
}

class Wood(): BaseBuildingMaterial() {
    override val numberNeeded: Int = 4;
}
class Brick(): BaseBuildingMaterial() {
    override val numberNeeded: Int = 8;
}

class Building<out T: BaseBuildingMaterial>(val baseBuildingMaterial: T) {
    val baseMaterialNeeded = 100;
    val actualMaterialNeeded = baseBuildingMaterial.numberNeeded * baseMaterialNeeded
    fun build() {
        println(baseBuildingMaterial::class.simpleName + ' ' + actualMaterialNeeded)
    }

    fun <T: BaseBuildingMaterial> isSmallBuilding() = actualMaterialNeeded < 500
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>) = building.actualMaterialNeeded < 500


fun main() {
    val building = Building<Wood>(Wood())
    building.build();

    isSmallBuilding(building)
}