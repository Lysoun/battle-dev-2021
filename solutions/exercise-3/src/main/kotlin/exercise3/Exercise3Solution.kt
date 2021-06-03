fun main(args: Array<String>) {
    val input = List(20) { readLine()!! }
    val holesByLines = input.map { it.mapIndexed { index, c -> index to c }.filter { it.second == '.' }.toMap() }
    var boom: Int? = null
    var i = 0
    while (boom == null && i < 10) {
        var ceiling = false
        var j = 0
        while (boom == null && !ceiling && j < 17) {
            if(!holesByLines[j].containsKey(i)) {
                ceiling = true
                System.err.println("Ceiling found at line $j")
            } else if(holesByLines.subList(j, j+4).all { it.size == 1 && it.containsKey(i) } &&
                (j == 16 || (j < 16 && !holesByLines[j+4].containsKey(i))) ) {
                boom = i
            }
            ++j
        }

        ++i
    }

    if (boom == null) {
        println("NOPE")
    } else {
        println("BOOM ${boom + 1}")
    }
}