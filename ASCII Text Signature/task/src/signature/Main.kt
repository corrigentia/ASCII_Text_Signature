package signature

import java.io.File
import kotlin.math.abs

private const val THREE = 3
private const val FOUR = 4
private const val FIVE = 5
private const val SIX = 6
private const val SEVEN = 7
private const val EIGHT = 8
private const val NINE = 9
private const val TEN = 10

fun howManyNumbersIn(fileReference: File): Int {
    var numbers = 0
    fileReference.forEachLine {
        if (it.first().isDigit()) ++numbers
    }
    return numbers
}

fun numberOfWords(fileReference: File): Int {
    val text = fileReference.readText()
    return text.split(" ").size
}

fun longestWord(fileReference: File): Int {
    var max = 0
    fileReference.forEachLine {
        if (it.length > max) max = it.length
    }
    return max
}

fun sum(a: Int, b: Int): Int = a + b

val sumObject: (Int, Int) -> Int = ::sum
val sumResult: Int = sum(1, 2)

fun getRealGrade(x: Double) = x
fun getGradeWithPenalty(x: Double) = x - 1

fun getScoringFunction(isCheater: Boolean): (Double) -> Double {
    if (isCheater) {
        return ::getGradeWithPenalty
    }
    return ::getRealGrade
}

val wantedFunction = getScoringFunction(isCheater = false)

fun same(x: Int) = x
fun square(x: Int) = x * x
fun triple(x: Int) = 3 * x

fun applyAndSum(a: Int, b: Int, transformation: (Int) -> Int): Int {
    return transformation(a) + transformation(b)
}

fun isNotDot(char: Char): Boolean = char != '.'
const val ORIGINAL_TEXT = "I don't know... what to say..."
val textWithoutDots = ORIGINAL_TEXT.filter(::isNotDot)

fun fizzbuzz(from: Int, to: Int, transformation: (Int) -> String) {
    for (number in from..to) {
        println(transformation(number))
    }
}

fun last() {
    fizzbuzz(1, 100) { number ->
        if (number % 15 == 0) {
            return@fizzbuzz "fizzbuzz"
        }
        if (number % 3 == 0) {
            return@fizzbuzz "fizz"
        }
        if (number % 5 == 0) {
            return@fizzbuzz "buzz"
        }
        return@fizzbuzz number.toString()
    }
}

const val SPACE = " "
const val BORDER = "8"

private fun wrap(surrounding: String, core: String): String = surrounding + core + surrounding

private fun wrapInDoubleSpaces(text: String): String {
    val twoSpaces = SPACE.repeat(2)
    return wrap(twoSpaces, text)
}

private fun wrapInDoubleBorders(text: String): String {
    val doubleBorder = BORDER.repeat(2)
    return wrap(doubleBorder, text)
}

private fun firstPartOfFirstElement(listOfString: List<String>): String = listOfString.first().split(SPACE).first()
private fun firstNumberFromFirstElement(listOfString: List<String>): Int = firstPartOfFirstElement(listOfString).toInt()

fun main() {
    // println(File(".").canonicalPath)
    val nameTagFontAddress = "roman.txt"
    val statusFontAddress = "medium.txt"

    /*
    println(File(nameTagFontAddress).canonicalPath)
    println(File(statusFontAddress).canonicalPath)*/

    val nameTagFontReference = File(nameTagFontAddress)
    val statusFontReference = File(statusFontAddress)

    if (!nameTagFontReference.exists()) println("try address other than $nameTagFontAddress!")

    /*println(
        """
nameTagFontAddress: nameTagFontAddress,
statusFontAddress: statusFontAddress,
nameTagFontReference: nameTagFontReference,
statusFontReference: statusFontReference,
nameTagFontReference.exists(): ${nameTagFontReference.exists()}
statusFontReference.exists(): ${statusFontReference.exists()}
        """.trimIndent()
    )*/

    val nameTagChars: List<String> = nameTagFontReference.readLines()
    // println(nameTagChars.joinToString("\n"))

    val statusChars = statusFontReference.readLines()
    // println(statusChars.joinToString("\n"))

    val nameTagHeight: Int = firstNumberFromFirstElement(nameTagChars)
    val statusHeight: Int = firstNumberFromFirstElement(statusChars)
    // println("romanHeight: $nameTagHeight, mediumHeight: $statusHeight")

    println("Enter name and surname: ")
    val fullName = readLine()!! // "A b" // "Ian One" // readLine()!!
    val (firstName, lastName) = fullName.split(SPACE) // .map { it.toCharArray().joinToString(SPACE) }

    println("Enter person's status: ")
    val statusInput = readLine()!! // "long participant" // "VIP" // readLine()!!
    val statusParts = statusInput.split(SPACE)

/*
    var topTopAlphabet = """____ ___  ____ ___  ____ ____ ____ _  _ _  _ _  _ _    _  _ """
    var middleAlphabet = """|__| |__] |    |  \ |___ |___ | __ |__| |  | |_/  |    |\/| """
    var bottomAlphabet = """|  | |__] |___ |__/ |___ |    |__] |  | | _| | \_ |___ |  | """

    topTopAlphabet += """_  _ ____ ___  ____ ____ ____ ___ _  _ _  _ _ _ _ _  _ _   _ ___ """
    middleAlphabet += """|\ | |  | |__] |  | |__/ [__   |  |  | |  | | | |  \/   \_/    / """
    bottomAlphabet += """| \| |__| |    |_\| |  \ ___]  |  |__|  \/  |_|_| _/\_   |    /__"""
*/

/*
    println(
        """
        firstName: $firstName,
        lastName: $lastName
        """.trimIndent()
    )
*/

    val emptyString = ""
    // val alphabet = ('a'..'z').joinToString(emptyString)

    val collectionOfNameTags = Array(nameTagHeight) { emptyString }

    for (char in firstName) {
        // println("char: $char, firstName: $firstName")
        for (line in nameTagChars) {
            // println("line: $line")
            if (char.toString() == line.split(SPACE).first()) {
                /*
                println(
                    """char: $char, char.toString(): ${char.toString()}, line: $line, line.split(SPACE): ${
                        line.split(
                            SPACE
                        )
                    }, line.split(SPACE).first(): ${line.split(SPACE).first()},
                    char.toString() == line.split(SPACE).first(): ${char.toString() == line.split(SPACE).first()}
                    """
                )
*/
                val index = nameTagChars.indexOf(line)
                // println("index: $index")
                for (offset in 1..nameTagHeight) {
                    // println("offset: $offset, offset - 1: ${offset - 1}, index + 1: ${index + offset}")
                    // println("collectionOfNameTags[offset - 1]: ${collectionOfNameTags[offset - 1]}, romanLines[index + 1]: ${romanLines[index + offset]}")
                    collectionOfNameTags[offset - 1] += nameTagChars[index + offset]
                    // println("collectionOfNameTags[offset - 1]: ${collectionOfNameTags[offset - 1]}, romanLines[index + 1]: ${romanLines[index + offset]}")
                }
            }
        }
    }

    // println("first name before space")
    // for (index in collectionOfNameTags.indices) println("x" + collectionOfNameTags[index] + "x")
    for (index in collectionOfNameTags.indices) collectionOfNameTags[index] += SPACE.repeat(TEN)
    // for (index in collectionOfNameTags.indices) println("x" + collectionOfNameTags[index] + "x")
    // println("first name after space")

    for (char in lastName) {
        for (line in nameTagChars) {
            if (char.toString() == line.split(SPACE).first()) {
                val index = nameTagChars.indexOf(line)
                for (offset in 1..nameTagHeight) {
                    collectionOfNameTags[offset - 1] += nameTagChars[index + offset]
                }
            }
        }
    }

    // for (index in collectionOfNameTags.indices) println("x" + collectionOfNameTags[index] + "x")
    // println("last name after space")

/*
    for (char in fullNameTag) when (val char = char.lowercaseChar()) {
        in alphabet -> {
            val letterOrdinal = alphabet.indexOf(char)
            var letterWidth: Int
            var startIndex: Int
            var endIndex: Int
            when (char) {
                'i' -> {
                    letterWidth = 1
                    startIndex = letterOrdinal * FOUR + letterOrdinal
                    endIndex = startIndex + letterWidth
                }
                'j' -> {
                    letterWidth = 2
                    startIndex = letterOrdinal * FOUR + letterOrdinal - THREE
                    endIndex = startIndex + letterWidth
                }
                't' -> {
                    letterWidth = THREE
                    startIndex = letterOrdinal * FOUR + letterOrdinal - FIVE
                    endIndex = startIndex + letterWidth
                }
                'w', 'y' -> {
                    letterWidth = FIVE
                    startIndex = letterOrdinal * FOUR + letterOrdinal - if (char == 'w') SIX else FIVE
                    endIndex = startIndex + letterWidth
                }
                else -> {
                    letterWidth = FOUR
                    startIndex = letterOrdinal * FOUR + letterOrdinal - when {
                        alphabet.indexOf(char) > alphabet.indexOf('y') -> FOUR
                        alphabet.indexOf(char) > alphabet.indexOf('w') -> FIVE
                        alphabet.indexOf(char) > alphabet.indexOf('t') -> SIX
                        alphabet.indexOf(char) > alphabet.indexOf('k') -> FIVE
                        alphabet.indexOf(char) > alphabet.indexOf('i') -> FIVE
                        else -> 0
                    }
                    endIndex = startIndex + letterWidth
                }
            }
            nameTag01 += topTopAlphabet.substring(startIndex, endIndex)
            nameTag02 += middleAlphabet.substring(startIndex, endIndex)
            nameTag10 += bottomAlphabet.substring(startIndex, endIndex)
        }
        else -> {
            nameTag01 += topTopAlphabet.substring(FOUR, FIVE)
            nameTag02 += middleAlphabet.substring(FOUR, FIVE)
            nameTag10 += bottomAlphabet.substring(FOUR, FIVE)
        }
    }
*/

    // println("before status")

    val collectionOfStatusTags = Array(statusHeight) { emptyString }

    for (char in statusParts.first()) {
        for (line in statusChars) {
            if (char.toString() == line.split(SPACE).first()) {
                val index = statusChars.indexOf(line)
                for (offset in 1..statusHeight) {
                    collectionOfStatusTags[offset - 1] += statusChars[index + offset]
                }
            }
        }
    }

    if (statusParts.size > 1) {
        for (statusPartIndex in 1..statusParts.lastIndex) {
            for (tagIndex in collectionOfStatusTags.indices) collectionOfStatusTags[tagIndex] += SPACE.repeat(FIVE)
            for (char in statusParts[statusPartIndex]) {
                for (line in statusChars) {
                    if (char.toString() == line.split(SPACE).first()) {
                        val index = statusChars.indexOf(line)
                        for (offset in 1..statusHeight) {
                            collectionOfStatusTags[offset - 1] += statusChars[index + offset]
                        }
                    }
                }
            }
        }
    }

    // for (tag in collectionOfStatusTags) println(tag)

    // println("after status")
/*
    println(
        """
collectionOfNameTags: ${collectionOfNameTags.joinToString()},
collectionOfStatusTags: ${collectionOfStatusTags.joinToString()},
collectionOfTags: ${collectionOfTags.joinToString()}
        """.trimIndent()
    )
*/

    // for (index in collectionOfTags.indices) println(collectionOfTags[index])

/*
    println(
        """
collectionOfNameTags[0].length: ${collectionOfNameTags[0].length}
collectionOfStatusTags[0].length: ${collectionOfStatusTags[0].length}
collectionOfNameTags[0].length > collectionOfStatusTags[0].length: ${collectionOfNameTags[0].length > collectionOfStatusTags[0].length}        
        """.trimIndent()
    )
*/

    if (collectionOfNameTags[0].length > collectionOfStatusTags[0].length) {
        for (index in collectionOfNameTags.indices) {
            collectionOfNameTags[index] = wrapInDoubleSpaces(collectionOfNameTags[index])
        }

        val tagLengthDifference = abs(collectionOfNameTags[0].length - collectionOfStatusTags[0].length)
        val halfDifferenceTagLength = tagLengthDifference / 2
        val sidePadding = SPACE.repeat(halfDifferenceTagLength)
        if (tagLengthDifference % 2 != 0) {
            for (index in collectionOfStatusTags.indices) {
                collectionOfStatusTags[index] += SPACE
            }
        }

        for (index in collectionOfStatusTags.indices) {
            collectionOfStatusTags[index] = wrapInDoubleBorders(
                wrap(
                    surrounding = sidePadding, core = collectionOfStatusTags[index]
                )
            )
            // println(collectionOfStatusTags[index])
        }

        for (index in collectionOfNameTags.indices) {
            collectionOfNameTags[index] = wrapInDoubleBorders(collectionOfNameTags[index])
            // println(collectionOfNameTags[index])
        }
    } else {
        for (index in collectionOfStatusTags.indices) {
            collectionOfStatusTags[index] = wrapInDoubleSpaces(collectionOfStatusTags[index])
        }

        val tagLengthDifference = abs(collectionOfNameTags[0].length - collectionOfStatusTags[0].length)
        val halfDifferenceTagLength = tagLengthDifference / 2
        val sidePadding = SPACE.repeat(halfDifferenceTagLength)

        if (tagLengthDifference % 2 != 0) {
            for (index in collectionOfNameTags.indices) {
                collectionOfNameTags[index] += SPACE
            }
        }

        for (index in collectionOfNameTags.indices) {
            collectionOfNameTags[index] =
                wrapInDoubleBorders(wrap(surrounding = sidePadding, core = collectionOfNameTags[index]))
        }

        for (index in collectionOfStatusTags.indices) {
            collectionOfStatusTags[index] = wrapInDoubleBorders(collectionOfStatusTags[index])
        }
    }
    val lineLength = collectionOfNameTags[0].length
    val horizontalBorder = BORDER.repeat(lineLength)

    println(horizontalBorder)
    for (tag in collectionOfNameTags) println(tag)
    for (tag in collectionOfStatusTags) println(tag)
    println(horizontalBorder)

    applyAndSum(1, 2, ::same) //    returns 3 =   1   +   2
    applyAndSum(1, 2, ::square) //  returns 5 = 1 * 1 + 2 * 2
    applyAndSum(1, 2, ::triple) //  returns 9 = 3 * 1 + 3 * 2
}
