package carrental

class Invoice(private val total: Double) {

    override fun toString(): String {
        return "Total: $total"
    }
}
