package tictactoe

enum class Value {
    X {
        override fun toString() = "X"
    },
    O {
        override fun toString() = "O"
    },
    B {
        override fun toString() = "_"
    }
}
