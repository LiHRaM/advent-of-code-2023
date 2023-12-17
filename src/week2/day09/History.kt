package week2.day09

class History(input: String) {
    val future: Long by lazy {
        val differences = getDifferences(input)

        var value = 0L
        do {
            val currentRow = differences.removeLast()
            value += currentRow.last()
        } while (differences.isNotEmpty())

        value
    }

    val past: Long by lazy {
        val differences = getDifferences(input)

        var value = 0L
        do {
            val currentRow = differences.removeLast()
            value = currentRow.first() - value
        } while (differences.isNotEmpty())

        value
    }

    private fun getDifferences(input: String): MutableList<MutableList<Long>> {
        val differences = mutableListOf(
            input.split(" ").map { it.toLong() }.toMutableList(),
        )

        while (!differences.last().all { it == 0L }) {
            val nextRow = differences
                .last()
                .windowed(2)
                .map { (left, right) ->
                    right - left
                }
                .toMutableList()

            if (nextRow.size == 0) {
                break
            }

            differences.add(nextRow)
        }
        return differences
    }
}