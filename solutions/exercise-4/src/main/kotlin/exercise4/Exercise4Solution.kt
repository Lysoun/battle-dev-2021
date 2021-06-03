fun readLineToInt() = readLine()!!.toInt()

fun main(args: Array<String>) {
    val orbitSize = readLineToInt()
    val garbage = readLine()!!

    var count = 0
    val part1Characters = garbage.substring(0, orbitSize / 2)
        .groupBy { it }
        .map { it.key to it.value.size }
        .toMap()
        .toMutableMap()
    val part2Characters = garbage.substring(orbitSize / 2, orbitSize)
        .groupBy { it }
        .map { it.key to it.value.size }
        .toMap()
        .toMutableMap()

    for (i in 0 until orbitSize / 2) {

        if (part1Characters == part2Characters) {
            ++count
        }

        val nextPart1Character = garbage[(orbitSize / 2) + i]
        val nextPart2Character = garbage[i]
        subtractOrRemove(part1Characters, garbage[i])
        part1Characters[nextPart1Character] = (part1Characters[nextPart1Character]?:0) + 1
        subtractOrRemove(part2Characters, garbage[(orbitSize / 2) + i])
        part2Characters[nextPart2Character] = (part2Characters[nextPart2Character]?:0) + 1
    }

    println(count * 2)
}

fun subtractOrRemove(map: MutableMap<Char, Int>, key: Char) {
    if(map[key] == 1) {
        map.remove(key)
    } else {
        map[key] = map[key]!! - 1
    }
}