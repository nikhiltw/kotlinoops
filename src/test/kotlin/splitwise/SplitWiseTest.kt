package splitwise

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SplitWiseTest {

    @Test
    fun testSplit() {
        val input = arrayOf(3, 5, 7, 11, 14)

        val splitWise = SplitWise(input)

        val transactions = splitWise.split()

        val expectedTransactions = listOf(
            Transaction(0, 3, Money(3)),
            Transaction(0, 4, Money(2)),
            Transaction(1, 4, Money(3)),
            Transaction(2, 4, Money(1))
        )

        assertEquals(expectedTransactions, transactions)
    }

}