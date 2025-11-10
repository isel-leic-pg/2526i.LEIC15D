

import pt.isel.canvas.*

// Criação do Canvas de jogo, com fundo branco.
val canvas = Canvas(BOARD_SIZE, BOARD_SIZE, WHITE)

// Estado do jogo:
var gameState: GameState = GameState()

// -----------------------------------------------------------------------------
// Função main com o único ponto de mutabilidade
// - Desenha o tabuleiro inicial
// - Regista o evento do rato para as jogadas
// - Por cada jogada é devolvido um novo estado, sendo a var gameState atualizada
// - Faz o render com base no novo estado do jogo
// -----------------------------------------------------------------------------
fun main() {
    onStart {
        canvas.draw(GameState())
        canvas.onMouseDown { me ->
            gameState = gameState.makeMove(Position(me.x, me.y))
            canvas.draw(gameState)
        }
    }
    onFinish {}
}





