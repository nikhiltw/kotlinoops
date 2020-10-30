package librarymanagement

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class LibraryTest {

    @Test
    fun testGetAvailableBooksWhenNoBooksAreIssued() {
        val library = Library()
        library.add(Book(1, "one", 100))
        library.add(Book(2, "two", 200))

        val expectedBooks = listOf(Book(1, "one", 100), Book(2, "two", 200))

        assertEquals(expectedBooks, library.getAvailableBooks())
    }

    @Test
    fun testGetAvailableBooksWhenABookIsIssued() {
        val bookTwo = Book(2, "two", 200)

        val library = Library()
        library.add(Book(1, "one", 100))
        library.add(bookTwo)

        library.markAsUnAvailable(bookTwo)

        val expectedBooks = listOf(Book(1, "one", 100))

        assertEquals(expectedBooks, library.getAvailableBooks())
    }

    @Test
    fun testGetAvailableBooksWhenABookPutBackAgain() {
        val bookTwo = Book(2, "two", 200)

        val library = Library()
        library.add(Book(1, "one", 100))
        library.add(bookTwo)

        library.markAsUnAvailable(bookTwo)
        library.markAsAvailable(bookTwo)

        val expectedBooks = listOf(Book(1, "one", 100), Book(2, "two", 200))

        assertEquals(expectedBooks, library.getAvailableBooks())
    }

}