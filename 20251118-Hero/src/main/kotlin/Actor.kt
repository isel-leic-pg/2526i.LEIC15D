
/**
 * Represents an actor in the grid with a position and direction.
 * @property location The position of the actor in the grid.
 * @property direction The direction the actor is facing.
 */
data class Actor(val cell: Cell, val direction: Direction)



/**
 * Generates a list of random robot actors, excluding a specified cell.
 * @param exclude The cell to exclude from robot placement.
 * @return A list of actors placed in random cells without overlapping.
 */
fun randomRobots(exclude: Cell): List<Actor> = (allCells() - exclude)
    .shuffled()
    .take(MAX_ROBOTS)
    .map { Actor(it, Direction.DOWN) }
