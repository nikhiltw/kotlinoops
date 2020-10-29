package tictactoe

import java.io.Writer

class Game(
    private val playerOne: Player,
    private val playerTwo: Player,

    private val board: Board,
    private val validator: Validator,
    private val writer: Writer
) {

    private var isPlayerOneTurn = true

    fun execute(): Player {
        while (!board.isComplete()) {
            val curr = if (isPlayerOneTurn) playerOne else playerTwo

            var input = validator.validate(curr.getInput())

            while (input == null) {
                writer.write("invalid input please enter again")
                input = validator.validate(curr.getInput())
            }

            board.place(input.coordinate, input.value)

            isPlayerOneTurn = !isPlayerOneTurn
        }

        return if (isPlayerOneTurn) playerTwo else playerOne
    }

}
