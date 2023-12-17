package week2.day08

/**
 * Greatest common divisor
 */
fun gcd(a: ULong, b: ULong): ULong {
    var num1 = a
    var num2 = b

    while (num2.compareTo(0u) != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }

    return num1
}

/**
 * Least common multiple.
 */
fun lcm(a: ULong, b: ULong): ULong = (a / gcd(a, b)) * b

class GhostMap(lines: List<String>) {
    private val instructions = Instructions(lines[0])
    private val nodes = lines.asSequence().drop(2).map { line -> Node(line) }
    private val graph = nodes.map { node -> Pair(node.name, Pair(node.left, node.right)) }.toMap()

    val stepsToGoal: ULong by lazy {
        nodes
            .map { node -> node.name }
            .filter { node -> node.endsWith("A") }
            .map { initialNode ->
                var current = initialNode

                for ((steps, instruction) in instructions.infinite.withIndex()) {
                    if (current.endsWith('Z')) {
                        return@map steps.toULong()
                    }
                    val (left, right) = graph[current] ?: throw NotImplementedError("Node not in graph: $current")
                    current = when (instruction) {
                        Instruction.Left -> left
                        Instruction.Right -> right
                    }
                }
                throw NotImplementedError("Can't reach this point!")
            }
            .reduce { acc, el -> lcm(acc, el) }
    }
}