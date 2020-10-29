package carrental

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TripTest {

    @Test
    fun testTripStart() {
        val trip = Trip("id", User(1), Car(1, CarType.SIX_WHEELER))
        trip.start()

        assertThrows(UnsupportedOperationException::class.java) { trip.start() }
    }

    @Test
    fun testTripEndSuccess() {
        val trip = Trip("id", User(1), Car(1, CarType.SIX_WHEELER))
        trip.start()
        trip.end()
    }

    @Test
    fun testTripEndFailureOnNewTrip() {
        val trip = Trip("id", User(1), Car(1, CarType.SIX_WHEELER))

        assertThrows(UnsupportedOperationException::class.java) { trip.end() }
    }

    @Test
    fun testTripEndFailureOnCompletedTrip() {
        val trip = Trip("id", User(1), Car(1, CarType.SIX_WHEELER))
        trip.start()
        trip.end()

        assertThrows(UnsupportedOperationException::class.java) { trip.end() }
    }

}