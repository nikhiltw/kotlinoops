package carrental

enum class CarType {
    TWO_WHEELER {
        override fun getBasePrice(): Double {
            return 20.0
        }
    },

    FOUR_WHEELER {
        override fun getBasePrice(): Double {
            return 40.0
        }
    },

    SIX_WHEELER {
        override fun getBasePrice(): Double {
            return 60.0
        }
    };

    abstract fun getBasePrice(): Double
}
