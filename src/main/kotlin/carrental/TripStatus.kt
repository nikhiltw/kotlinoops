package carrental

enum class TripStatus {
    CREATED, IN_PROGRESS, COMPLETED;

    fun toInProgress(): TripStatus {
        if (this != CREATED) throw UnsupportedOperationException("cannot start this trip")
        return IN_PROGRESS
    }

    fun toEnd(): TripStatus {
        if (this != IN_PROGRESS) throw UnsupportedOperationException("cannot end this trip")
        return COMPLETED
    }

}
