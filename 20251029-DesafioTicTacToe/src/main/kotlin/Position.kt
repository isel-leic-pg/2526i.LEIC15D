

// Estrutura simples para representar uma posição (coordenadas x, y) no Canvas.
data class Position(val x: Int, val y: Int)

// -----------------------------------------------------------------------------
// Converte coordenadas do rato (x,y) na célula correspondente (índice 0..8)
// -----------------------------------------------------------------------------
fun Position.toCellIdx(cellSize: Int, colsPerRow: Int ): Int = (y / cellSize) * colsPerRow + (x / cellSize)

// Calcula o centro de uma célula (para desenhar o símbolo no meio da mesma)
fun Int.cellCenter(cellSize: Int, colsPerRow: Int ): Position {
    val col = this % colsPerRow   // Coluna (0, 1 ou 2)
    val row = this / colsPerRow   // Linha (0, 1 ou 2)
    val cx = col * cellSize + cellSize / 2
    val cy = row * cellSize + cellSize / 2
    return Position(cx, cy)
}


