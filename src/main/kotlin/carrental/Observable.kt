package carrental

import java.time.Duration

interface Observable {
    fun add(observer: Observer)
    fun notify(duration: Duration, carType: CarType)
}
