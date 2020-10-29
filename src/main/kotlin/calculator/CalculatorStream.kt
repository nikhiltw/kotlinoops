package calculator

import java.util.*

class CalculatorStream {

    private val calculator = Calculator()
    private val operations: Queue<Pair<Int, (Int, Int) -> Int>> = ArrayDeque()

    fun add(a: Int): CalculatorStream {
        operations.add(Pair(a, calculator::add))
        return this
    }

    fun compute(): Int {
        var res = 0
        operations.forEach { res = it.second(res, it.first) }
        return res
    }

    fun sub(a: Int): CalculatorStream {
        operations.add(Pair(a, calculator::sub))
        return this
    }

    fun div(a: Int): CalculatorStream {
        if (operations.isEmpty()) throw UnsupportedOperationException("cannot divide with nothing")
        operations.add(Pair(a, calculator::div))
        return this
    }

    fun mul(a: Int): CalculatorStream {
        operations.add(Pair(a, calculator::mul))
        return this
    }

}
