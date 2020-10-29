package splitwise

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TransactionTest {

    @Test
    fun testToString() {
        val transaction = Transaction(1, 2, Money(3))
        assertEquals("Person(1) -> Person(2): Money(3)", transaction.toString())
    }
}