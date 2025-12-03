

//Adapted from code developed by Prof. Pedro Pereira for class 2526i.LEIC11D (https://github.com/isel-leic-pg/2526i.LEIC11D/tree/main/Hero ).

import pt.isel.canvas.*


const val CELL_SIZE = 128
const val GRID_WIDTH = 11
const val GRID_HEIGHT = 7

const val CANVAS_WIDTH = CELL_SIZE * GRID_WIDTH
const val CANVAS_HEIGHT = CELL_SIZE * GRID_HEIGHT

const val MAX_ROBOTS = 10


/**
 * Simple canvas-based application that allows moving a hero character within a grid using arrow keys.
 */
fun main() {

    onStart {

        val hero = Actor(Cell(GRID_WIDTH/2, GRID_HEIGHT/2), Direction.DOWN)
        val robots = randomRobots(hero.cell)
        val canvas = Canvas(CANVAS_WIDTH, CANVAS_HEIGHT, WHITE)

        var game = Game(hero, robots)

        canvas.draw(game)

        canvas.onKeyPressed { key ->
            val direction: Direction? = key.toDirection()
            if(direction!=null && (game.hero.cell + direction).isInGrid()){
                game = Game(Actor(game.hero.cell + direction, direction), game.robots)
                canvas.draw(game)
            }
        }

        /*
        val arena = Canvas(GRID_WIDTH*CELL_SIZE, GRID_HEIGHT*CELL_SIZE, WHITE)
        //hero initial position
        var pos = Cell(GRID_WIDTH/2, GRID_HEIGHT/2)
        updateView(arena,pos)
        arena.onKeyPressed { key ->
            val dir = key.toDir()
            if (dir!=null && (pos+dir).isInGrid()) {
                pos += dir
                updateView(arena, pos)
            }
        }
        */

    }
    onFinish {  }
}


//DONE: (3)
fun KeyEvent.toDirection(): Direction? = when(code) {
    LEFT_CODE -> Direction.LEFT
    RIGHT_CODE -> Direction.RIGHT
    UP_CODE -> Direction.UP
    DOWN_CODE -> Direction.DOWN
    else -> null
}




