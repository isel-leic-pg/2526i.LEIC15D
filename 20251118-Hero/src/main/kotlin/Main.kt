
/*Based on the code developed by Prof. Pedro Pereira for class 2526i.LEIC11D (https://github.com/isel-leic-pg/2526i.LEIC11D/tree/main/Hero).*/

import pt.isel.canvas.*

const val CELL_SIZE = 128
const val GRID_WIDTH = 5
const val GRID_HEIGHT = 3


/**
 * Simple canvas-based application that allows moving a hero character within a grid using arrow keys.
 */
fun main() {
    onStart {
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
    }
    onFinish {  }
}


private fun updateView(arena: Canvas, pos: Cell) {
    arena.erase()
    arena.drawGrid()
    arena.drawHero(pos)
}

//DONE: (3)
fun KeyEvent.toDir(): Dir? = when(code) {
    LEFT_CODE -> Dir.LEFT
    RIGHT_CODE -> Dir.RIGHT
    UP_CODE -> Dir.UP
    DOWN_CODE -> Dir.DOWN
    else -> null
}




