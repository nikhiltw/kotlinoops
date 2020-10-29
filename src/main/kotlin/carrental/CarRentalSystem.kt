package carrental

import java.time.Duration

class CarRentalSystem(private val inventory: Inventory) : Observable {

    private val trips: MutableMap<String, Trip> = mutableMapOf()
    private val observers: MutableList<Observer> = mutableListOf()

    fun browseCars(): List<Car> {
        return inventory.getAvailableCars()
    }

    fun createTrip(user: User, car: Car): String {
        val id = "${user.id}${car.id}"

        if (trips.containsKey(id)) throw IllegalArgumentException("cannot crete the same trip again")

        inventory.markAsBooked(car)
        trips[id] = Trip(id, user, car)
        return id
    }

    fun startTrip(tripID: String) {
        val trip = trips[tripID] ?: throw IllegalArgumentException("invalid trip id")

        trip.start()
    }

    fun endTrip(tripID: String) {
        val trip = trips[tripID] ?: throw IllegalArgumentException("invalid trip id")

        inventory.unMarkAsBooked(trip.car)
        val duration = trip.end()

        notify(duration, trip.car.carType)
    }

    override fun add(observer: Observer) {
        observers.add(observer)
    }

    override fun notify(duration: Duration, carType: CarType) {
        observers.forEach { it.update(duration, carType) }
    }

}
