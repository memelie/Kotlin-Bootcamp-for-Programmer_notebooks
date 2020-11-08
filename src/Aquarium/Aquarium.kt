package Aquarium

open class Aquarium (var height: Int = 50, var width: Int = 50, var length: Int = 100) {

    var volume: Int
        get() = height * width * length / 1000
        set(value) { height = (value / 1000) / (width * length) }

    open val water = volume * 0.9

    constructor(numberOfFish : Int) : this() {
        val water = numberOfFish * 1000;
    }
}

class TowerTank () :Aquarium() {
    override val water = volume * 0.5;
}