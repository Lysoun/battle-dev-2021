fun readLineToInt() = readLine()!!.toInt()

fun main(args: Array<String>) {
    println(findButton())
}

fun findButton(): String {
    val N = readLineToInt()
    val commands = mutableMapOf<String, Int>()

    for(i in 0 until N) {
        val command = readLine()!!
        commands[command] = (commands[command]?: 0) + 1
    }

    return commands.filter { it.value == 2 }.keys.first()
}