package carrental

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

internal class CarRentalSystemTest {

    private val inventory = Inventory()

    @BeforeEach
    fun setUp() {
        inventory.addCar(Car(1, CarType.TWO_WHEELER))
        inventory.addCar(Car(2, CarType.FOUR_WHEELER))
        inventory.addCar(Car(3, CarType.SIX_WHEELER))
    }

    @Test
    fun bookCarSuccess() {
        val priceCalculator = PriceCalculator()

        val carRentalSystem = CarRentalSystem(inventory, priceCalculator)

        val car = carRentalSystem.browseCars().first { it.carType == CarType.FOUR_WHEELER }
        val user = User(1)

        val tripID = carRentalSystem.createTrip(user, car)
        carRentalSystem.startTrip(tripID)

        val invoice = carRentalSystem.endTrip(tripID)
        assertEquals("Total: 1440.0", invoice.toString())
    }

    @Test
    fun bookCarFailureWhenCreateTripFails() {
        val priceCalculator = PriceCalculator()

        val carRentalSystem = CarRentalSystem(inventory, priceCalculator)

        val car = carRentalSystem.browseCars().first { it.carType == CarType.FOUR_WHEELER }
        val user = User(1)

        carRentalSystem.createTrip(user, car)
        assertThrows(IllegalArgumentException::class.java) { carRentalSystem.createTrip(user, car) }
    }

    @Test
    fun bookCarFailureWhenStartTripFailsForInvalidId() {
        val carRentalSystem = CarRentalSystem(inventory, PriceCalculator())
        assertThrows(IllegalArgumentException::class.java) { carRentalSystem.startTrip("invalidID") }
    }

    @Test
    fun bookCarFailureWhenEndTripFailsForInvalidId() {
        val carRentalSystem = CarRentalSystem(inventory, PriceCalculator())
        assertThrows(IllegalArgumentException::class.java) { carRentalSystem.endTrip("invalidID") }
    }

    @Test
    fun bookCarFailureWhenEndTripFailsBeforeStartingTrip() {
        val priceCalculator = PriceCalculator()

        val carRentalSystem = CarRentalSystem(inventory, priceCalculator)

        val car = carRentalSystem.browseCars().first { it.carType == CarType.FOUR_WHEELER }
        val user = User(1)

        val tripID = carRentalSystem.createTrip(user, car)

        assertThrows(UnsupportedOperationException::class.java) { carRentalSystem.endTrip(tripID) }
    }

}