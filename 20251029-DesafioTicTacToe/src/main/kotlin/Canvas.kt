
import pt.isel.canvas.*

// -----------------------------------------------------------------------------
// - Canvas - A vista (view)
// -----------------------------------------------------------------------------
// Constantes que definem o tamanho do tabuleiro e das células.
const val BOARD_SIZE = 300        // Tamanho total do Canvas em pixels (300x300) - configurável
const val COLS_PER_ROW = 3         // Número de células por linha/coluna (3x3)
const val CELL_SIZE = BOARD_SIZE / COLS_PER_ROW  // Tamanho de cada célula (100px) - adaptável


fun Canvas.draw(gameState: GameState){

    //ERASE
    erase()

    //DRAW GRID
    //desenha linhas verticais e linhas horizontais
    for (i in 1 until COLS_PER_ROW) {
        // Linhas verticais
        canvas.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, BOARD_SIZE)
        // Linhas horizontais
        canvas.drawLine(0, i * CELL_SIZE, BOARD_SIZE, i * CELL_SIZE)
    }

    //DRAW SYMBOLS
    gameState.board.forEachIndexed { idx, value ->
        val center = idx.cellCenter(CELL_SIZE, COLS_PER_ROW)
        when (value) {
            2 -> canvas.drawCircle(center.x, center.y, 20, BLUE)
            //exemplo para utilização de imagens
            1 -> canvas.drawImage("x1.png", center.x-25,center.y-25,50,50  )
        }
    }

    //DRAW MESSAGE
    if(gameState.gameOver) canvas.drawText(CELL_SIZE, BOARD_SIZE - 20, gameState.message, BLACK, 20)

}








