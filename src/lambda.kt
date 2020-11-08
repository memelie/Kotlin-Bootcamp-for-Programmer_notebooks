import java.util.*

fun main(args: Array<String>) {
    var rollDice: (Int) -> Int = { sides: Int ->
        when (sides) {
            0 -> 0
            else -> (Math.random() * sides + 1).toInt()
        }
    }


    fun gamePlay (rollDice: Int = rollDice(6)) {
        println(rollDice)
    }

    gamePlay()
}
