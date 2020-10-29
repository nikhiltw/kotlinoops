package calculator

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.lang.UnsupportedOperationException
import kotlin.test.assertEquals

internal class CalculatorStreamTest {

    @Test
    fun testStreamWithAddOperation() {
        val stream = CalculatorStream()
        assertEquals(1, stream.add(1).compute())
    }

    @Test
    fun testStreamWithSubOperation() {
        val stream = CalculatorStream()
        assertEquals(-1, stream.sub(1).compute())
    }

    @Test
    fun testStreamWithDivOperationSuccess() {
        val stream = CalculatorStream()
        assertEquals(1, stream.add(1).div(1).compute())
    }

    @Test
    fun testStreamWithDivOperationFailure() {
        val stream = CalculatorStream()
        assertThrows(UnsupportedOperationException::class.java) { stream.div(1).compute() }
    }

    @Test
    fun testStreamWithMulOperation() {
        val stream = CalculatorStream()
        assertEquals(0, stream.mul(1).compute())
    }

    @Test
    fun testStreamWithMultipleOperation() {
        val stream = CalculatorStream()
        val res = stream.add(10).sub(2).mul(5).div(2)
        assertEquals(20, res.compute())
    }

    @Test
    fun testStreamWithLargeOperation() {
        val stream = CalculatorStream()

        val res = stream.add(424).sub(2).add(424).sub(2)
            .mul(5).sub(2).div(2).div(2)
            .mul(5).div(2).add(424).mul(5)

        assertEquals(15295, res.compute())
    }

}