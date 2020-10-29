package carrental

import java.time.Duration


class Trip(id: String, user: User, val car: Car) {

    private var tripStatus: TripStatus = TripStatus.CREATED

    fun start() {
        if (tripStatus != TripStatus.CREATED) throw UnsupportedOperationException("cannot start the trip")

        tripStatus = tripStatus.next()
    }

    // TEMP IMPLEMENTATION FOR DURATION
    fun end(): Duration {
        if (tripStatus != TripStatus.IN_PROGRESS) throw UnsupportedOperationException("cannot stop the trip")

        tripStatus = tripStatus.next()
        return Duration.ofHours(1)
    }
}
