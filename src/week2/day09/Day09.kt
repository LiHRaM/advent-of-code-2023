package week2.day09

import println
import readInput

fun main() {
    val input = readInput("Day09-1")
    val histories = Histories(input)

    histories.future.println()
    histories.past.println()
}
