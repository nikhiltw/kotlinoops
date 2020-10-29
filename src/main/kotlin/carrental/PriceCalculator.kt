package carrental

import java.time.Duration
import java.time.temporal.ChronoUnit

class PriceCalculator {

    fun calculate(duration: Duration, carType: CarType): Double {
        return duration.get(ChronoUnit.SECONDS) / 100 * carType.getBasePrice()
    }

}
