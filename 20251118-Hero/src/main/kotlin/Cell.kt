data class Cell(val col:Int, val row:Int)


//DONE: (4)
operator fun Cell.plus(direction: Direction): Cell = when(direction) {
    Direction.LEFT -> Cell(col-1, row)
    Direction.RIGHT -> Cell(col+1, row)
    Direction.UP -> Cell(col, row-1)
    Direction.DOWN -> Cell(col, row+1)
}

//DONE: (5)
fun Cell.isInGrid() = col in 0..<GRID_WIDTH && row in 0..<GRID_HEIGHT

