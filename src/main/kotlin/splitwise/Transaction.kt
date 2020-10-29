package splitwise

data class Transaction(private val payeeID: Int, private val beneficiaryID: Int, private val amount: Money) {

    override fun toString(): String {
        return "Person($payeeID) -> Person(${beneficiaryID}): $amount"
    }

}
