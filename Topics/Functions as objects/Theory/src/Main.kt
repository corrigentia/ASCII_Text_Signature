// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    // put your code here
    changeAndPrint()
    changeAndPrint()
}

var count = 0

val changeAndPrint = {
    println(++count)
}
