package carrental

enum class TripStatus {
    CREATED {
        override fun next(): TripStatus {
            return IN_PROGRESS
        }
    },

    IN_PROGRESS {
        override fun next(): TripStatus {
            return COMPLETED
        }
    },

    COMPLETED {
        override fun next(): TripStatus {
            throw UnsupportedOperationException("trip is completed")
        }
    };

    abstract fun next(): TripStatus
}
