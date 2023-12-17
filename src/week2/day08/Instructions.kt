package week2.day08

enum class Instruction {
    Left, Right;
}

fun <T> Sequence<T>.cycle() = sequence {
    while (true) {
        yieldAll(this@cycle)
    }
}

class Instructions(input: String) {
    init {
        if (input.any { it !in listOf('L', 'R') }) {
            throw NotImplementedError("Input not supported, contains invalid characters: $input")
        }
    }

    val infinite = input
        .map {
            when (it) {
                'L' -> Instruction.Left
                'R' -> Instruction.Right
                else -> throw NotImplementedError("Invalid instruction: $it")
            }
        }
        .toTypedArray()
        .asSequence()
        .cycle()
}