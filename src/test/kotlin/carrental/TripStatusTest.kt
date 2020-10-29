package carrental

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TripStatusTest {

    @Test
    fun testNext() {
        assertEquals(TripStatus.IN_PROGRESS, TripStatus.CREATED.toInProgress())
        assertEquals(TripStatus.COMPLETED, TripStatus.IN_PROGRESS.toEnd())

        assertThrows(UnsupportedOperationException::class.java) { TripStatus.IN_PROGRESS.toInProgress() }
        assertThrows(UnsupportedOperationException::class.java) { TripStatus.CREATED.toEnd() }
        assertThrows(UnsupportedOperationException::class.java) { TripStatus.COMPLETED.toInProgress() }
        assertThrows(UnsupportedOperationException::class.java) { TripStatus.COMPLETED.toEnd() }
    }

}