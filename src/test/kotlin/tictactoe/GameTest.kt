package tictactoe

import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.test.assertEquals

internal class GameTest {

    @Test
    fun testExecutePlayerOneWins() {
        val stringWriter = StringWriter()
        val writer = BufferedWriter(stringWriter)

        val validator = Validator()

        val oneReader = Mockito.mock(BufferedReader::class.java)
        Mockito.`when`(oneReader.readLine()).thenReturn("0,0").thenReturn("0,1").thenReturn("0,2")
        val playerOne = User(Value.X, oneReader)

        val twoReader = Mockito.mock(BufferedReader::class.java)
        Mockito.`when`(twoReader.readLine()).thenReturn("1,1").thenReturn("2,2")
        val playerTwo = User(Value.O, twoReader)

        val board = Board(3)

        val game = Game(playerOne, playerTwo, board, validator, writer)

        val winner = game.execute()

        assertEquals(playerOne, winner)
    }

    @Test
    fun testExecutePlayerTwoWins() {
        val stringWriter = StringWriter()
        val writer = BufferedWriter(stringWriter)

        val validator = Validator()

        val oneReader = Mockito.mock(BufferedReader::class.java)
        Mockito.`when`(oneReader.readLine()).thenReturn("0,0").thenReturn("2,2").thenReturn("0,2")
        val playerOne = User(Value.X, oneReader)

        val twoReader = Mockito.mock(BufferedReader::class.java)
        Mockito.`when`(twoReader.readLine()).thenReturn("1,0").thenReturn("1,1").thenReturn("1,2")
        val playerTwo = User(Value.O, twoReader)

        val board = Board(3)

        val game = Game(playerOne, playerTwo, board, validator, writer)

        val winner = game.execute()

        assertEquals(playerTwo, winner)
    }

}