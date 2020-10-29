package tictactoe

class Validator {

    fun validate(input: Pair<String, Value>): Input? {
        if (input.first.split(",").map { Integer.parseInt(it) }.count() != 2)
            return null

        val c = input.first.split(",")
        return Input(Coordinate(c[0].toInt(), c[1].toInt()), input.second)
    }

}
