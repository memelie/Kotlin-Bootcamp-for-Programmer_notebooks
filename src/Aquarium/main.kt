package Aquarium

fun main (args: Array<String>) {
    // buildAquarium()
    makeFish()
}

fun buildAquarium () {
    val myAquarium = Aquarium();
    println("Length : ${myAquarium.length}" +
            "Height : ${myAquarium.height}" +
            "Width : ${myAquarium.width}"
    )
    myAquarium.length = 80;
    println("Length : ${myAquarium.length}")
}

fun feedFish(fish: FishAction) {
    fish.eat();
}

fun makeFish() {
    val shark = Shark();
    val plecostomus = Plecostomus();
    println("Shark color : ${shark.color} and Plecostomus color : ${plecostomus.color}");
    shark.eat();
    plecostomus.eat();
    feedFish(shark)
}