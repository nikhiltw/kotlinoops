package carrental

import org.junit.jupiter.api.Test
import java.time.Duration
import kotlin.test.assertEquals

internal class PaymentSystemTest {

    @Test
    fun testGetInvoice() {
        val priceCalculator = PriceCalculator()
        val paymentSystem = PaymentSystem(priceCalculator)

        val observable = object : Observable {
            private val observers: MutableList<Observer> = mutableListOf()

            override fun add(observer: Observer) {
                observers.add(observer)
            }

            override fun notify(duration: Duration, carType: CarType) {
                observers.forEach { it.update(duration, carType) }
            }
        }

        observable.add(paymentSystem)
        observable.notify(Duration.ofHours(1), CarType.FOUR_WHEELER)

        assertEquals(Invoice(1440.0), paymentSystem.getInvoice())
    }

}