package week2.day08

class Node(private val line: String) {
    private val regex = Regex("^(?<Node>[A-Z1-9]{3}) = \\((?<Left>[A-Z1-9]{3}), (?<Right>[A-Z1-9]{3})\\)$")
    private val matches = regex.matchEntire(line) ?: throw NotImplementedError("$line is not supported by $regex")

    val name = matches.groupValues[1]
    val left = matches.groupValues[2]
    val right = matches.groupValues[3]
}