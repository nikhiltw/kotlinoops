package calculator

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CalculatorTest {

    inner class TestCase(val expectedResult: Int, val a: Int, val b: Int)

    private val calculator: Calculator = Calculator()

    @Test
    fun testAdd() {
        val testCases = listOf(
            TestCase(4, 2, 2),
            TestCase(6, 4, 2),
            TestCase(-6, -4, -2)
        )

        testCases.forEach { testFun(it.expectedResult, it.a, it.b, calculator::add) }
    }

    @Test
    fun testSub() {
        val testCases = listOf(
            TestCase(0, 2, 2),
            TestCase(2, 4, 2),
            TestCase(-2, -4, -2)
        )

        testCases.forEach { testFun(it.expectedResult, it.a, it.b, calculator::sub) }
    }

    @Test
    fun testMul() {
        val testCases = listOf(
            TestCase(4, 2, 2),
            TestCase(8, 4, 2),
            TestCase(8, -4, -2)
        )

        testCases.forEach { testFun(it.expectedResult, it.a, it.b, calculator::mul) }
    }

    @Test
    fun testDiv() {
        val testCases = listOf(
            TestCase(1, 2, 2),
            TestCase(2, 4, 2),
            TestCase(2, -4, -2)
        )

        testCases.forEach { testFun(it.expectedResult, it.a, it.b, calculator::div) }
    }

    private fun testFun(expectedResult: Int, a: Int, b: Int, fn: (Int, Int) -> Int) {
        assertEquals(expectedResult, fn(a, b))
    }
}