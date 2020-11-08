import java.util.*

fun main(args: Array<String>) {
    print("How do you feel today? ")
    val mood: String? = readLine();
    val lastMood = if (mood!!.isNotEmpty()) mood else "happy";
    println(whatShouldIDoToday(lastMood, "rainy"))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    fun isHappyAndSunny() = mood == "happy" && weather == "sunny"
    fun isHappyAndRainy() = mood == "happy" && weather == "rainy"
    fun isSadAndSunny() = mood == "sad" && weather == "sunny"
    fun isVeryBadDay() = mood == "sad" && weather == "rainy" && temperature == 0
    fun isHot() = temperature > 35
    return when {
        isHappyAndSunny() -> "Go for a walk"
        isHappyAndRainy() -> "Take an umbrella"
        isSadAndSunny() -> "Call your friend"
        isVeryBadDay() -> "stay in bed"
        isHot() -> "go swimming"
        else -> "Stay home and read"
    }
}