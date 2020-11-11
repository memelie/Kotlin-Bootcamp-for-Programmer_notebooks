package Aquarium

data class Fish(var name: String)

fun main() {
    // fishExamples();
    listExamples();
}

fun fishExamples() {
    val fish = Fish("splashy");

    myWith (fish.name) {
        println(capitalize());
    }

    println(fish.run {name})
    println(fish.apply{})

    val fish2 = Fish("Splashy2").apply{name = "Sharky"}
    println(fish2.name)

    println(fish.let{it.name.capitalize()}
        .let{it + "fish"}
        .let{it.length}
    )
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block();
}


fun listExamples() {
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0);
    val divByThree = { num: Int -> num % 3 }
    val numbersDivisibleByThree = divisible(numbers) {
        divByThree(this)
    }
    println(numbersDivisibleByThree)
}

fun divisible(list: List<Int>, block: Int.() -> Int): List<Int> {
    val result = mutableListOf<Int>();
    list.forEach {
        if (block(it) == 0) {
            result.add(it);
        }
    }
    return result;
}