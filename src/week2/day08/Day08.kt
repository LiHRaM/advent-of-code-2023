package week2.day08

import println
import readInput

fun main() {
    val input = readInput("Day08-1")

    Map(input).stepsToGoal.println()
    GhostMap(input).stepsToGoal.println()
}

