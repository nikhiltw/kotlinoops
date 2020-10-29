package tictactoe

import java.io.BufferedReader

class User(private val value: Value, private val reader: BufferedReader) : Player {

    override fun getInput(): Pair<String, Value> {
        return Pair(reader.readLine(), value)
    }

}
