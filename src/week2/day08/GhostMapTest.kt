package week2.day08

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import readTestInput

class GhostMapTest {
    @TestFactory
    fun testInputs() = listOf(
        "Day08-3" to 6u,
        "Day08-4" to 6u,
    ).map { (filename: String, expected) ->
        DynamicTest.dynamicTest("File $filename has $expected steps") {
            val testInput = readTestInput(filename)
            assertEquals(expected, GhostMap(testInput).stepsToGoal)
        }
    }
}