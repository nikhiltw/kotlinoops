package tictactoe

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.lang.NumberFormatException
import kotlin.test.*

internal class ValidatorTest {

    @Test
    fun testValidInputSuccess() {
        val validator = Validator()
        val res = validator.validate(Pair("1,2", Value.X))

        assertNotNull(res)
        assertEquals(Coordinate(1, 2), res.coordinate)
        assertEquals(Value.X, res.value)
    }

    @Test
    fun testValidInputFailure() {
        val validator = Validator()

        val r1 = validator.validate(Pair("12", Value.X))
        assertNull(r1)

        val r2 = validator.validate(Pair("1,2,3", Value.X))
        assertNull(r2)

        assertThrows(NumberFormatException::class.java) { validator.validate(Pair("1, 2", Value.X)) }
        assertThrows(NumberFormatException::class.java) { validator.validate(Pair("", Value.X)) }
        assertThrows(NumberFormatException::class.java) { validator.validate(Pair(" ", Value.X)) }
        assertThrows(NumberFormatException::class.java) { validator.validate(Pair("a,b", Value.X)) }

    }

}