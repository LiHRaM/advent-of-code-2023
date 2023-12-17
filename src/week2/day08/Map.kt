package week2.day08

class Map(lines: List<String>) {
    private val instructions = Instructions(lines[0])
    private val nodes = lines.asSequence().drop(2).map { line -> Node(line) }
    private val graph = nodes.map { node -> Pair(node.name, Pair(node.left, node.right)) }.toMap()

    val stepsToGoal: Int by lazy {
        var current = "AAA"
        var steps = 0

        for (instruction in instructions.infinite) {
            if (current == "ZZZ") {
                break
            }

            val (left, right) = graph[current] ?: throw NotImplementedError("Node not in graph: $current")

            current = when (instruction) {
                Instruction.Left -> left
                Instruction.Right -> right
            }

            steps += 1
        }

        steps
    }
}