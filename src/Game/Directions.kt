package Game

enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
}

fun move(where: () -> Boolean) {
    where();
}

class Location(val startH: Int, val startW: Int, val width: Int = 4, val height: Int = 4) {
    val map = Array(width) { arrayOfNulls<String>(height) }
    init {
        for(h in 0 until height) {
            for(w in 0 until width) {
                map[h][w] = "You are in position ${h} ${w}"
            }
        }
    }
    var currentH = startH;
    var currentW = startW;
    var currentLocation = {println(map[currentH][currentW])}
    fun updateLocation(move: String?) {
        when(move) {
            "north" -> {
                if (currentH > 0) {
                    currentH -= 1;
                }
            }
            "south" -> if (currentH < height - 1) {
                currentH += 1;
            }
            "east" -> if (currentW < width - 1) {
                currentW += 1;
            }
            "west" -> if (currentW > 0) {
                currentW -= 1;
            }
            else -> println("ending")
        }
        currentLocation();
    }

}

class Game() {
    var path: MutableList<Directions> = mutableListOf(Directions.START);
    val north = {path.add(Directions.NORTH);}
    val south = {path.add(Directions.SOUTH);}
    val east = {path.add(Directions.EAST);}
    val west = {path.add(Directions.WEST);}
    val end = {
        path.add(Directions.END);
        println("Game over");
        println(path.toString());
        path = mutableListOf(Directions.START);
        false;
    }
    val location = Location(0, 0)
    fun makeMove(moveToMake: String?) {
        location.updateLocation(moveToMake)
        when(moveToMake) {
            "north" -> move(north)
            "south" -> move(south)
            "east" -> move(east)
            "west" -> move(west)
            else -> move(end)
        }
    }
}

fun main() {
    val game = Game();
    /* println(game.path);
    game.north()
    game.north()
    game.south()
    game.east()
    game.west()
    game.end() */
    while(true){
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readLine())
    }
}