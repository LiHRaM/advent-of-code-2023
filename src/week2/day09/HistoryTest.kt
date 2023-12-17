package week2.day09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class HistoryTest {
    @TestFactory
    fun testForwardPrediction() = listOf(
        "0 3 6 9 12 15" to 18L,
        "1 3 6 10 15 21" to 28L,
        "10 13 16 21 30 45" to 68L,
        "16 30 62" to 13261777L,
        "0 -2 -4" to -6L,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Value of $input is $expected") {
            assertEquals(expected, History(input).future)
        }
    }


    @TestFactory
    fun testBackwardsPrediction() = listOf(
        "0 3 6 9 12 15" to -3L,
        "1 3 6 10 15 21" to 0L,
        "10 13 16 21 30 45" to 5L,
        "0 -2 -4" to 2L,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Value of $input is $expected") {
            assertEquals(expected, History(input).past)
        }
    }
}