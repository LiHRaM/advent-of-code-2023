package week2.day09

class Histories(input: List<String>) {
    private val history = input.map { History(it) }

    val future: Long = history.sumOf { it.future }
    val past: Long = history.sumOf { it.past }
}