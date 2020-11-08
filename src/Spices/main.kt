package Spices

fun main (args: Array<String>) {
    val mySpice = SimpleSpice();
    println("Name : ${mySpice.name}" +
            "\nHeat : ${mySpice.heat}"
    )
    val cumin = Spice("Cumin", spiciness="none");
    val greenCurry = Spice("Green Curry");
    val pimento = Spice("Pimento", "hot");
    val listOfSpices: List<Spice> = listOf(cumin, greenCurry, pimento);
    val listOfHotSpices: List<Spice> = listOfSpices.filter { it.heat >= 5 }
    val listOfHColdSpices: List<Spice> = listOfSpices.filter { it.heat < 5 }
    println(listOfHColdSpices);
    println(listOfHotSpices);
    val salt = makeSalt();
    println(salt);
}

fun makeSalt()= Spice("salt", "none");