// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    // put your code here
    println(reinitializeCounter())
}

private const val SAME_NUMBER = -42

var counter: () -> Int = { SAME_NUMBER }

fun reinitializeCounter(): Int {
    var value = 0
    counter = { ++value }
    return value
}
