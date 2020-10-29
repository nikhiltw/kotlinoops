package tictactoe

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BoardTest {

    @Nested
    inner class TestIsBoardComplete {

        @Test
        fun testIsBoardNotCompleteForNewBoard() {
            val board = Board(3)
            assertFalse(board.isComplete())
        }

        @Test
        fun testIsBoardCompleteWhenRowIsFull() {
            val board = Board(3)

            board.place(Coordinate(0, 0), Value.X)
            board.place(Coordinate(0, 1), Value.X)
            board.place(Coordinate(0, 2), Value.X)

            assertTrue(board.isComplete())
        }

        @Test
        fun testIsBoardCompleteWhenColumnIsFull() {
            val board = Board(3)

            board.place(Coordinate(0, 0), Value.X)
            board.place(Coordinate(1, 0), Value.X)
            board.place(Coordinate(2, 0), Value.X)

            assertTrue(board.isComplete())
        }

        @Test
        fun testIsBoardCompleteWhenLeftDiagonalIsFull() {
            val board = Board(3)

            board.place(Coordinate(0, 0), Value.X)
            board.place(Coordinate(1, 1), Value.X)
            board.place(Coordinate(2, 2), Value.X)

            assertTrue(board.isComplete())
        }

        @Test
        fun testIsBoardCompleteWhenRightDiagonalIsFull() {
            val board = Board(3)

            board.place(Coordinate(0, 2), Value.X)
            board.place(Coordinate(1, 1), Value.X)
            board.place(Coordinate(2, 0), Value.X)

            assertTrue(board.isComplete())
        }

    }

    @Nested
    inner class TestBoardPlace {

        @Test
        fun testPlaceOnBlankCell() {
            val board = Board(3)
            board.place(Coordinate(0, 0), Value.X)
            assertEquals("X__\n___\n___\n", board.toString())
        }

        @Test
        fun testPlaceOnNonBlankCell() {
            val board = Board(3)

            board.place(Coordinate(0, 0), Value.X)
            assertEquals("X__\n___\n___\n", board.toString())

            assertThrows(UnsupportedOperationException::class.java) { board.place(Coordinate(0, 0), Value.X) }
        }

    }

    @Test
    fun testBoardToString() {
        val board = Board(3)
        assertEquals("___\n___\n___\n", board.toString())
    }

}