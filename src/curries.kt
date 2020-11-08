import java.util.*

fun main(args: Array<String>) {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper", "mild curry" )
    sortTheCurries(spices)
    getCandE(spices)
    getCandE_2(spices)
    getFirstThreeC(spices)
}

fun sortTheCurries(spices: List<String>) {
    val curries = spices.filter{it.contains("curry")}
    val sortedCurries = curries.sortedBy { it.length }

    println(sortedCurries)
}

fun getCandE(spices: List<String>) {
    val curries = spices.filter{it[0] == 'c' && it.last() == 'e'}
    println(curries)
}

fun getCandE_2(spices: List<String>) {
    val curries = spices.filter{it.startsWith('c') && it.endsWith('e')}
    println(curries)
}

fun getFirstThreeC(spices: List<String>) {
    val firstThree = spices.slice(0..2);
    val curries = firstThree.filter{it.startsWith('c')}
    println(curries)
}