package carrental

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class InvoiceTest {

    @Test
    fun testToString() {
        val invoice = Invoice(100.0)
        assertEquals("Total: 100.0", invoice.toString())
    }

}