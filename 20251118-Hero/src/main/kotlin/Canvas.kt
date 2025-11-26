import pt.isel.canvas.Canvas

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