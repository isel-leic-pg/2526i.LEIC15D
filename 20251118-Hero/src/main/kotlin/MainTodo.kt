import pt.isel.canvas.*


const val CELL_SIZE = 128
const val GRID_WIDTH = 5
const val GRID_HEIGHT = 3

data class Cell(val col:Int, val row:Int)

enum class Dir { LEFT, RIGHT, UP, DOWN }

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


/**
 * Draws a grid on the canvas.
 * @receiver The canvas on which to draw the grid.
 */
//DONE: (1)
fun Canvas.drawGrid() {
    
    for(x in 0..width step CELL_SIZE)
        drawLine(x, 0, x, height)
    for(y in 0..height step CELL_SIZE)
        drawLine(0, y, width, y)

    //alternative version, using "repeat"
    /*    
    repeat(GRID_WIDTH) {
        val x = it * CELL_SIZE
        drawLine(x, 0, x, height)
    }
    repeat(GRID_HEIGHT) {
        val y = it * CELL_SIZE
        drawLine(0, y, width, y)
    }
     */
}


/**
 * Draws the hero character at the specified cell position on the canvas.
 * @receiver The canvas on which to draw the hero.
 * @param p The cell position where the hero should be drawn.
 */
//DONE: (2)
fun Canvas.drawHero(p: Cell) {

    val filename = "hero|48,0,48,48"
    drawImage(
        fileName = filename,
        xLeft = p.col*CELL_SIZE,
        yTop = p.row*CELL_SIZE,
        width = CELL_SIZE,
        height = CELL_SIZE
    )

}


//TODO: (3)
fun KeyEvent.toDir(): Dir? = when(code) {

}

//TODO: (4)
operator fun Cell.plus(dir: Dir): Cell = when(dir) {

}

//TODO: (5)
fun Cell.isInGrid() = ...



