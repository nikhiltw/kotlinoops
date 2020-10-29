package carrental

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TripStatusTest {

    @Test
    fun testNext() {
        assertEquals(TripStatus.IN_PROGRESS, TripStatus.CREATED.next())
        assertEquals(TripStatus.COMPLETED, TripStatus.IN_PROGRESS.next())

        assertThrows(UnsupportedOperationException::class.java) { TripStatus.COMPLETED.next() }
    }

}