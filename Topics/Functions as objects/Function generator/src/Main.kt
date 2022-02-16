// TODO: provide three functions here
fun identity(number: Int) = number
fun half(number: Int) = number / 2
fun zero(number: Int) = 0

fun generate(functionName: String): (Int) -> Int {
    return when (functionName) {
        "identity" -> ::identity
        "half" -> ::half
        "zero" -> ::zero
        else -> ::zero
    }
}
