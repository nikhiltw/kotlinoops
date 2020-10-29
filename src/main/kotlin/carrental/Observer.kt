package carrental

import java.time.Duration

interface Observer {
    fun update(duration: Duration, carType: CarType)
}
