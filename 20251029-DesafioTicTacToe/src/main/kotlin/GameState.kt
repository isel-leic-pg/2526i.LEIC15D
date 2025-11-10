

// Estado do jogo:
// - 'board' representa o tabuleiro (lista de 9 posições: 0 = vazio, 1 = jogador 1, 2 = jogador 2)
// - 'currentPlayer' indica o jogador ativo
// - 'gameOver' indica se o jogo terminou (vitória ou empate)
// - 'message' mensagem no fim do jogo (vencedor ou empate)
data class GameState (
    val board: List<Int> = List(9) { 0 },
    val currentPlayer: Int = 1,
    val gameOver: Boolean = false,
    val message: String = ""
)


// -----------------------------------------------------------------------------
// Lógica principal de cada jogada:
// -----------------------------------------------------------------------------

fun GameState.makeMove(position: Position) : GameState {
    if (gameOver) {
        return GameState()
    }

    // Determina o índice da lista de acordo com a célula selecionada no canvas
    val cellIdx = position.toCellIdx(CELL_SIZE, COLS_PER_ROW)
    // Se já estiver ocupada devolve uma cópia do estado atual
    if (board[cellIdx] != 0) return this.copy()

    // Cria um novo board (imutável) com o símbolo do currentPlayer
    val newBoard = board.mapIndexed { idx, value ->
        if (idx == cellIdx) currentPlayer else value
    }

    // Verifica se o jogo terminou (vitória ou empate)
    val winner = newBoard.checkWinner()

    //board.none { it == 0 }  neste caso, retorna true se não existir nenhum elemento na lista com o inteiro 0 (predicado)
    //se existir um vencedor (1 ou 2) ou se já foram preenchidas todas as células e não há um vencedor (empate)
    if (winner != 0 || newBoard.none {v -> v == 0}) {

        val message = when (winner) {
            1 -> "Jogador 1 venceu!"
            2 -> "Jogador 2 venceu!"
            else -> "Empate!" //
        }

        return GameState(board=newBoard, currentPlayer=currentPlayer, gameOver=true, message=message)
    }

    // Alterna o jogador (1 → 2, 2 → 1)
    val newCurrentPlayer = if (currentPlayer == 1) 2 else 1
    return GameState(board = newBoard, currentPlayer = newCurrentPlayer)
}


fun List<Int>.checkWinner(): Int {
    // Combinações vencedoras
    val wins = listOf(
        0, 1, 2,   // linha 1
        3, 4, 5,   // linha 2
        6, 7, 8,   // linha 3
        0, 3, 6,   // coluna 1
        1, 4, 7,   // coluna 2
        2, 5, 8,   // coluna 3
        0, 4, 8,   // diagonal principal
        2, 4, 6    // diagonal secundária
    )

    // Percorremos de 3 em 3 posições
    for (i in wins.indices step 3) {
        val a = wins[i]
        val b = wins[i + 1]
        val c = wins[i + 2]

        // Se os três valores forem iguais e não forem 0, temos um vencedor
        val v = this[a]
        if (v != 0 && v == this[b] && v == this[c])
            return v
    }

    // Nenhum vencedor encontrado
    return 0
}






