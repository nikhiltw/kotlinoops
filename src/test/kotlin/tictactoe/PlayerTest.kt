package tictactoe

import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.io.BufferedReader
import kotlin.test.assertEquals

internal class PlayerTest {

    @Test
    fun userGetInput() {
        val reader = Mockito.mock(BufferedReader::class.java)
        Mockito.`when`(reader.readLine()).thenReturn("0,1")

        val user: Player = User(Value.X, reader)

        assertEquals(Pair("0,1", Value.X), user.getInput())

    }

}