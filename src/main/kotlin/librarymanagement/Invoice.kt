package librarymanagement

class Invoice(private val total: Long) {

    override fun toString(): String {
        return "Total: $total"
    }
}
