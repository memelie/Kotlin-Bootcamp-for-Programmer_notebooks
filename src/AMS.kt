import java.util.*

fun main(args: Array<String>) {
    // println("Hello ${args[0]}!")
    // dayOfWeek()
    //println(if (args[0].toInt() < 12 ) {"Good morning, Kotlin"} else { "Good night, Kotlin"})
    var fortune = ""
    while (fortune !== "Take it easy and enjoy life!") {
        fortune = getFortuneCookie(getBirthday());
        println(fortune);
    }
    // println(fitMoreFish(8.0, listOf(2,2,2), hasDecorations = false));
}

fun dayOfWeek() {
    println("What day is it today?")
    val dayNumber = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    var dayString = "";
    when(dayNumber) {
        1 -> dayString = "Sunday"
        2 -> dayString = "Monday"
        3 -> dayString = "Tuesday"
        4 -> dayString = "Wednesday"
        5 -> dayString = "Thursday"
        6 -> dayString = "Friday"
        7 -> dayString = "Saturday"
        else -> dayString = dayNumber.toString()
    }
    println(dayString)
}

fun getBirthday(): Int {
    print("Enter your birthday: ");
    val birthday: Int = readLine()?.toIntOrNull() ?: 1;
    return birthday;
}

fun getFortuneCookie(birthday: Int): String {
    val listOfFortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.",
        "Happy end of month"
    );
    val index: Int = when(birthday) {
        in 1..7 -> 0
        in 28..31 -> 7
        else -> birthday % listOfFortunes.size;
    }
    return listOfFortunes[index];
};

fun fitMoreFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    val availableSpace: Double = when(hasDecorations){
        true -> 0.8
        else -> 1.0
    }
    val maxFish: Double = availableSpace.times(tankSize);
    val actualFish: Int = if (currentFish.isEmpty()) 0 else currentFish.reduce{x, fish -> x + fish};
    return actualFish + fishSize <= maxFish;
}