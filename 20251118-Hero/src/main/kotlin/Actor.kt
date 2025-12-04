
/**
 * Represents an actor in the grid with a position and direction.
 * @property cell The position of the actor in the grid.
 * @property direction The direction the actor is facing.
 */
data class Actor(val cell: Cell, val direction: Direction)



//DONE
val allCells = List(GRID_HEIGHT*GRID_WIDTH) { idx ->
    Cell(row = idx / GRID_WIDTH, col = idx % GRID_WIDTH )
}

/**
 * Generates a list of random robot actors, excluding a specified cell.
 * @param exclude The cell to exclude from robot placement.
 * @return A list of actors placed in random cells without overlapping.
 */
 //DONE
 fun randomRobots(exclude: Cell): List<Actor> = (allCells - exclude)
        .shuffled()
        .take(MAX_ROBOTS)
        .map { Actor(it, Dir.DOWN) }


