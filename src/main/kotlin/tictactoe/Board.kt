package tictactoe

class Board(private val size: Int) {

    private val matrix = Array(size) { Array(size) { Value.B } }

    fun isComplete() = isRowComplete() || isColumnComplete() || isDiagonalComplete()

    private fun isRowComplete() = check(true)

    private fun isColumnComplete() = check(false)

    private fun check(row: Boolean): Boolean {
        for (i in 0 until size) {
            var (cx, co) = Pair(0, 0)

            for (j in 0 until size) {
                matrix.get(i, j, row).takeIf { it != Value.B }?.let { if (it == Value.X) cx++ else co++ }
            }

            if (cx == size || co == size) return true
        }

        return false
    }

    private fun Array<Array<Value>>.get(i: Int, j: Int, row: Boolean): Value {
        return if (row) return get(i)[j] else get(j)[i]
    }

    private fun isDiagonalComplete() = isLeftDiagonalComplete() || isRightDiagonalComplete()

    private fun isLeftDiagonalComplete(): Boolean {
        var (cx, co) = Pair(0, 0)

        for (v in 0 until size) {
            if (matrix[v][v] == Value.B) break
            if (matrix[v][v] == Value.X) cx++ else co++
        }

        return (cx == size || co == size)
    }

    private fun isRightDiagonalComplete(): Boolean {
        var (cx, co) = Pair(0, 0)

        for (v in size - 1 downTo 0) {
            if (matrix[size - v - 1][v] == Value.B) break
            if (matrix[size - v - 1][v] == Value.X) cx++ else co++
        }

        return (cx == size || co == size)
    }

    fun place(coordinate: Coordinate, value: Value) = matrix.place(coordinate, value)

    private fun Array<Array<Value>>.place(coordinate: Coordinate, value: Value) {
        if (get(coordinate.x)[coordinate.y] != Value.B)
            throw UnsupportedOperationException("cannot place on a non blank cell")
        get(coordinate.x)[coordinate.y] = value
    }

    override fun toString(): String {
        return matrix.map { it.map { v -> v.toString() }.reduce { acc, s -> acc + s } }
            .fold("") { acc, s -> acc + s + "\n" }
    }

}
