package tictactoe

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ValueTest {

    @Test
    fun testToString() {
        assertEquals("X", Value.X.toString())
        assertEquals("O", Value.O.toString())
        assertEquals("_", Value.B.toString())
    }

}