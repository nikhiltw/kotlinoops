package splitwise

import java.util.*

class SplitWise(private val input: Array<Int>) {

    fun split(): List<Transaction> {
        val persons = input.mapIndexed { i, v -> Person(i, Money(v)) }

        val total = persons.map { it.amountPaid }.fold(Money(0)) { acc, curr -> acc + curr }

        val avg = total / input.size

        val (beneficiaries, payees) = persons.partition { it.amountPaid >= avg }.toQueue()

        val res = mutableListOf<Transaction>()

        while (!payees.isEmpty()) {
            val currPayee = payees.remove()
            var canPay = avg - currPayee.amountPaid

            while (!beneficiaries.isEmpty()) {
                val currBen = beneficiaries.remove()
                val canRec = if (currBen.amountPaid > avg) currBen.amountPaid - avg else currBen.amountPaid

                if (canPay > canRec) {
                    res.add(Transaction(currPayee.id, currBen.id, canRec))
                    canPay -= canRec
                } else if (canPay < canRec) {

                    res.add(Transaction(currPayee.id, currBen.id, canPay))
                    beneficiaries.add(Person(currBen.id, canRec - canPay))

                    break
                } else {
                    res.add(Transaction(currPayee.id, currBen.id, canPay))
                }

            }

        }


        return res
    }

    private fun <T> Pair<List<T>, List<T>>.toQueue(): Pair<Queue<T>, Queue<T>> {
        val res = Pair(ArrayDeque<T>(), ArrayDeque<T>())
        this.first.toCollection(res.first)
        this.second.toCollection(res.second)
        return res
    }

}
