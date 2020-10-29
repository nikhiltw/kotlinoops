package carrental

import java.time.Duration

class PaymentSystem(private val priceCalculator: PriceCalculator) : Observer {

    private val invoices = ArrayDeque<Invoice>()

    fun getInvoice(): Invoice {
        // BLOCKING CALL
        while (invoices.isEmpty()) { }
        return invoices.removeFirst()
    }

    override fun update(duration: Duration, carType: CarType) {
        invoices.add(Invoice(priceCalculator.calculate(duration, carType)))
    }

}
