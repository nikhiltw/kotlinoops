package splitwise

import java.lang.IllegalArgumentException

data class Money(private val value: Int) {

    operator fun plus(other: Money) = Money(value + other.value)

    operator fun div(d: Int) = Money(value / d)

    operator fun compareTo(other: Money) = value - other.value

    operator fun minus(other: Money): Money {
        if (other.value >= value) throw IllegalArgumentException("money cannot be less than 1")
        return Money(value - other.value)
    }

    override fun toString(): String {
        return "Money($value)"
    }
}
