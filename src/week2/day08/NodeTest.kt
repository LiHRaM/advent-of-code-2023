package week2.day08

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class NodeTest {
    @TestFactory
    fun testParses() = listOf(
        "AAA = (BBB, CCC)" to setOf("AAA", "BBB", "CCC"),
        "11A = (XXB, 22Z)" to setOf("11A", "XXB", "22Z"),
    ).map {(input, expected) ->
        DynamicTest.dynamicTest("From $input we parse $expected") {
            val node = Node(input)
            assertEquals(
                setOf(node.name, node.left, node.right),
                expected,
            )
        }
    }
}