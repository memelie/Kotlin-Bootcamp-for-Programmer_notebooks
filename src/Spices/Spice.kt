package Spices

class Spice(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get() = when(spiciness) {
            "hot" -> 10
            "mild" -> 5
            else -> 0
        }
    init {
        println("${name} is ${spiciness}")
    }
}