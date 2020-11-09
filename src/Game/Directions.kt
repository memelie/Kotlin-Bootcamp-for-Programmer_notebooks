package Game

enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
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

}

fun main() {
    val game = Game();
    println(game.path);
    game.north()
    game.north()
    game.south()
    game.east()
    game.west()
    game.end()
}