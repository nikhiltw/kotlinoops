package librarymanagement

import java.time.Duration
import java.time.temporal.ChronoUnit

class PaymentSystem {
    fun generateInvoice(duration: Duration, basePrice: Int): Invoice {
        val total = duration.get(ChronoUnit.SECONDS) / 1000 * basePrice
        return Invoice(total)
    }

}
