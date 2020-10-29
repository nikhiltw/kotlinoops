package carrental

import java.time.Duration


class Trip(id: String, user: User, val car: Car) {

    private var tripStatus: TripStatus = TripStatus.CREATED

    fun start() {
        tripStatus = tripStatus.toInProgress()
    }

    // TEMP IMPLEMENTATION FOR DURATION
    fun end(): Duration {
        tripStatus = tripStatus.toEnd()
        return Duration.ofHours(1)
    }
}
