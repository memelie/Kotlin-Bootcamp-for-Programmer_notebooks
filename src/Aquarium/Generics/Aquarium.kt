package Aquarium.Generics

open class WaterSupply (var needsProcessed: Boolean) {

}

class TapWater: WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false;
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true) {
    fun filter() {
        needsProcessed = false;
    }
}

class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessed) {"Water supply needs processed"}
        println("adding water from ${waterSupply}")
    }

}

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println(aquarium.waterSupply.needsProcessed)
}
inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R;
inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T;

fun main() {
    val aquarium = Aquarium<TapWater>(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    val aquariumLake = Aquarium<LakeWater>(LakeWater())
    aquariumLake.waterSupply.filter()
    aquariumLake.addWater()

    aquarium.hasWaterSupplyOfType<TapWater>()
    aquarium.waterSupply.isOfType<TapWater>()
}