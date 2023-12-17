package week2.day08

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import readTestInput

class MapTest {
    @TestFactory
    fun testInputs() = listOf(
        "Day08" to 2,
        "Day08-2" to 6,
    ).map { (filename, expected) ->
        DynamicTest.dynamicTest("File $filename has $expected steps") {
            val testInput = readTestInput(filename)
            assertEquals(expected, Map(testInput).stepsToGoal)
        }
    }
}