package splitwise

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class MoneyTest {

    @Test
    fun testAddMoney() {
        val hundred = Money(100)
        val twoHundred = Money(200)

        assertEquals(Money(300), hundred + twoHundred)
    }

    @Test
    fun testDivMoney() {
        val hundred = Money(100)

        assertEquals(Money(20), hundred / 5)
        assertThrows(
            ArithmeticException::class.java
        ) { hundred / 0 }
    }

    @Test
    fun testMoneyCompare() {
        val a = Money(100)
        val b = Money(200)
        val c = Money(50)
        val d = Money(100)

        assertTrue(a < b)
        assertTrue(a > c)
        assertTrue(a.compareTo(d) == 0)
    }

    @Test
    fun testSubMoney() {
        val a = Money(100)
        val b = Money(200)

        assertEquals(Money(100), b - a)
        assertThrows(IllegalArgumentException::class.java) { a - b }
    }

    @Test
    fun testToString() {
        val hundred = Money(100)
        assertEquals("Money(100)", hundred.toString())
    }

}