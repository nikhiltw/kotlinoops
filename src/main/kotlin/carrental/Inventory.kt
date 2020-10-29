package carrental

import java.lang.IllegalArgumentException

class Inventory {

    private val cars: MutableMap<Car, Boolean> = mutableMapOf()

    fun getAvailableCars(): List<Car> {
        return cars.filter { it.value }.map { it.key }.toList()
    }

    fun addCar(car: Car) {
        if (cars.containsKey(car)) throw IllegalArgumentException("car already present")

        cars[car] = true
    }

    fun markAsBooked(car: Car) {
        val available = cars[car] ?: throw IllegalArgumentException("car not present in inventory")
        if (!available) throw UnsupportedOperationException("car already booked")

        cars[car] = false
    }

    fun unMarkAsBooked(car: Car) {
        val available = cars[car] ?: throw IllegalArgumentException("car not present in inventory")
        if (available) throw UnsupportedOperationException("car already un booked")

        cars[car] = true
    }
}
