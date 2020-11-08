package Spices2

fun main() {
    val curry = Curry("hot");
    curry.grind()
    println("The color is : ${curry.color}");

    val c1 = SpiceContainer(curry);
    c1.printLabel();

}

sealed class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by color {
    val heat: Int
        get() = when(spiciness) {
            "hot" -> 10
            "mild" -> 5
            else -> 0
        }
    init {
        println("${name} is ${spiciness}")
    }

    abstract fun prepareSpice()
}

class Curry (spiciness: String, color: SpiceColor = YellowSpiceColor) : Spice("curry", spiciness, color), Grinder {
    override fun prepareSpice() {
        grind();
    }

}

interface Grinder {
    fun grind() {
        println("Grinding")
    }
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}

interface SpiceColor {
    val color: Color;
}

object YellowSpiceColor: SpiceColor {
    override val color = Color.YELLOW;
}

data class SpiceContainer (val spice: Spice) {
    val label = "${spice.name} container";
    fun printLabel() {
        println(label);
    }
}