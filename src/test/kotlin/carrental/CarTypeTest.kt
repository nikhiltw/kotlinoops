package carrental

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CarTypeTest {

    @Test
    fun testGetPriceForTwoWheeler() {
        assertEquals(20.0, CarType.TWO_WHEELER.getBasePrice())
    }

    @Test
    fun testGetPriceForFourWheeler() {
        assertEquals(40.0, CarType.FOUR_WHEELER.getBasePrice())
    }

    @Test
    fun testGetPriceForSixWheeler() {
        assertEquals(60.0, CarType.SIX_WHEELER.getBasePrice())
    }

}