package carrental

data class Invoice(private val total: Double) {

    override fun toString(): String {
        return "Total: $total"
    }
}
