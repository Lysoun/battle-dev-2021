fun readLineToInt() = readLine()!!.toInt()

fun main(args : Array<String>) {
    val D = readLineToInt()
    val L = readLineToInt()
    println(D + L * 5)
}