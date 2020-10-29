package carrental

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.Duration

internal class PriceCalculatorTest {

    @Test
    fun testCalculatePrice() {

        val priceCalculator = PriceCalculator()

        assertEquals(720.0, priceCalculator.calculate(Duration.ofHours(1), CarType.TWO_WHEELER))
        assertEquals(1440.0, priceCalculator.calculate(Duration.ofHours(1), CarType.FOUR_WHEELER))
        assertEquals(2160.0, priceCalculator.calculate(Duration.ofHours(1), CarType.SIX_WHEELER))

    }

}