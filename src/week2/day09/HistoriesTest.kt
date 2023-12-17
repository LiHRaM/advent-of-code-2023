package week2.day09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import readTestInput

class HistoriesTest {
    @TestFactory
    fun testValues() = listOf(
        "Day09-1" to 114,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Value of file $input is $expected") {
            assertEquals(Histories(readTestInput(input)).future, expected)
        }
    }
}