package librarymanagement

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

internal class ManagementSystemTest {

    @Nested
    inner class TestSearchBook {

        @Test
        fun testSearchBookWhenAvailable() {
            val library = Library()
            library.add(Book(1, "one", 100))

            val managementSystem = ManagementSystem(library, PaymentSystem())

            assertEquals(Book(1, "one", 100), managementSystem.searchBook("one"))
        }

        @Test
        fun testSearchBookWhenUnAvailable() {
            val bookOne = Book(1, "one", 100)

            val library = Library()
            library.add(bookOne)
            library.markAsUnAvailable(bookOne)

            val managementSystem = ManagementSystem(library, PaymentSystem())

            assertNull(managementSystem.searchBook("one"))
        }

        @Test
        fun testSearchBookIsNotPresent() {
            val library = Library()

            val managementSystem = ManagementSystem(library, PaymentSystem())

            assertNull(managementSystem.searchBook("one"))
        }
    }

    @Nested
    inner class TestBorrowBook {

        @Test
        fun testBorrowBook() {
            val library = Library()
            library.add(Book(1, "one", 100))

            val managementSystem = ManagementSystem(library, PaymentSystem())

            val book = managementSystem.searchBook("one")
            assertNotNull(book)

            val user = User(1)

            val success = managementSystem.borrow(user, book)
            assertTrue(success)
        }

    }

    @Nested
    inner class TestReturnBook {

        @Test
        fun testReturnBook() {
            val library = Library()
            library.add(Book(1, "one", 100))

            val managementSystem = ManagementSystem(library, PaymentSystem())

            val book = managementSystem.searchBook("one")
            assertNotNull(book)

            val user = User(1)

            val success = managementSystem.borrow(user, book)
            assertTrue(success)

            val invoice = managementSystem.returnBook(user, book)
            assertEquals("Total: 700", invoice.toString())
        }

    }

}