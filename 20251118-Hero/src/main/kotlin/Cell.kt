data class Cell(val col:Int, val row:Int)


//DONE: (4)
operator fun Cell.plus(dir: Dir): Cell = when(dir) {
    Dir.LEFT -> Cell(col-1, row)
    Dir.RIGHT -> Cell(col+1, row)
    Dir.UP -> Cell(col, row-1)
    Dir.DOWN -> Cell(col, row+1)
}

//DONE: (5)
fun Cell.isInGrid() = col in 0..<GRID_WIDTH && row in 0..<GRID_HEIGHT