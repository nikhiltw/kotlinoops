package librarymanagement

import org.junit.jupiter.api.Test
import java.time.Duration
import kotlin.test.assertEquals

internal class PaymentSystemTest {

    @Test
    fun testGenerateInvoice() {
        val paymentSystem = PaymentSystem()
        val invoice = paymentSystem.generateInvoice(Duration.ofHours(2), 100)
        assertEquals("Total: 700", invoice.toString())
    }

}