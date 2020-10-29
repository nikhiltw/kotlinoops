package carrental

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class InventoryTest {

    @Test
    fun testAddCar() {
        val inventory = Inventory()
        val car = Car(1, CarType.FOUR_WHEELER)

        inventory.addCar(car)

        assertThrows(IllegalArgumentException::class.java) { inventory.addCar(car) }
    }

    @Test
    fun testMarkAsBooked() {
        val inventory = Inventory()
        val car = Car(1, CarType.FOUR_WHEELER)

        inventory.addCar(car)
        inventory.markAsBooked(car)

        assertThrows(UnsupportedOperationException::class.java) { inventory.markAsBooked(car) }

        assertThrows(IllegalArgumentException::class.java) { inventory.markAsBooked(Car(2, CarType.FOUR_WHEELER)) }
    }

    @Test
    fun testUnMarkAsBooked() {
        val inventory = Inventory()
        val car = Car(1, CarType.FOUR_WHEELER)

        inventory.addCar(car)
        inventory.markAsBooked(car)
        inventory.unMarkAsBooked(car)

        assertThrows(UnsupportedOperationException::class.java) { inventory.unMarkAsBooked(car) }

        assertThrows(IllegalArgumentException::class.java) { inventory.markAsBooked(Car(2, CarType.FOUR_WHEELER)) }
    }

}