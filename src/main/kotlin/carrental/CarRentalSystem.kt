package carrental

class CarRentalSystem(private val inventory: Inventory, private val priceCalculator: PriceCalculator) {

    private val trips: MutableMap<String, Trip> = mutableMapOf()

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

    fun endTrip(tripID: String): Invoice {
        val trip = trips[tripID] ?: throw IllegalArgumentException("invalid trip id")

        inventory.unMarkAsBooked(trip.car)

        val duration = trip.end()
        val total = priceCalculator.calculate(duration, trip.car.carType)
        return Invoice(total)
    }

}
