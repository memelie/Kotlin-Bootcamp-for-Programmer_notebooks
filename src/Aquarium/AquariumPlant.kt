package Aquarium

fun String.hasSpaces() = find {it == ' '} !== null

fun extansionExample() {
    "Does it have spaces ?".hasSpaces();
}

open class AquariumPlant (val color: String, private val size: Int) {
}

class GreenLeafyPlant (size: Int): AquariumPlant("green", size) {
}



fun AquariumPlant.isRed() = color === "red";
fun AquariumPlant.print() = println("AquariumPlant");
fun GreenLeafyPlant.print() = println("leafyPlant");

fun exampleFunctions() {
    val leaf = GreenLeafyPlant(50);
    leaf.print();
    val aquariumPlant: AquariumPlant = leaf;
    aquariumPlant.print();
}