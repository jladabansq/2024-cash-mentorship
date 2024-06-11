import java.io.File
import kotlin.io.path.writeLines

fun main() {
    /******** Common Data Types ********/
    // immutable - read-only/cannot be changed
    val immutableVal: Boolean = true
    // printing to console
    println(immutableVal) // output: true

    // mutable
    var mutableVar: Int = 1
    println(mutableVar) // output: 1
    mutableVar += 1
    println(mutableVar) // output: 2


    // numeric data types: Byte, Short, Int, Long,

    // default type is Int (if it fits in 32-bit); else, will be inferred as Long
    // unsigned: UInt = 0U

    // floating points: default type is double
    val doubleVal: Double = 3.5
    val floatVal: Float = 4.5f

    // conversion of numeric data types
    println(doubleVal.toInt()) // output: 3
    println(mutableVar.toFloat()) // output: 2.0


    // char and strings
    // string in Kotlin are immutable
    val charValLetter: Char = 'a'
    val charValNumber: Char = '5'

    val stringVal = "Hello, world!"
    val stringEscaped = "Hello \n world!"
    val stringRaw = """
        This    is 
          really
        not      a 
          poetry
    """

    var variableRefer = "The first number with added 1 is ${mutableVar + 1}"
    println(variableRefer) // output: The first number is 3

    // built-in
    stringVal.isEmpty() // returns true even when the val have just spaces because space is still a valid character
    stringVal.isBlank() // returns true if the val only have spaces
    println(stringVal.contains("World")) // returns false because casing does not match
    stringVal.length


    // nullable types
    var stringNullable: String? = null
    // ? is used for null safe call
    println(stringNullable?.length) // output: null
    // ?: is the Elvis operator
    println(stringNullable?.length ?: "The value is null") // output: The value is null


    /******** Working with Functions ********/
    println(funcWithStringReturn())
    println(funcSingleExpression())
    funcWithPrint()
    funcWithParam(funcWithStringReturn())
    println(funcIncrementByOne(number = 5)) // named argument; output: 6


    funcFunctionalType() // same as funTypeWithNoReturnType.invoke()
    funcFunctionalType = {
        println("Changed funcTypeWithNoReturnType")
    }
    funcFunctionalType.invoke() // output: Changed funcTypeWithNoReturnType


    funcFunctionalTypeWithExplicitNaming("explicitly named")
    funcFunctionalTypeWithExplicitNaming.invoke("explicitly named")


    // trailing lambda syntax
    // output: The calculated value is 11
    funcHigherOrder(5, 6) { value1, value2 ->
        value1 + value2
    }


    // higher order functions challenge: write a name formatter
    val higherOrderChallengeBasicFormatter: (String, String) -> String = { first, last ->
        "$first $last"
    }
    val higherOrderChallengeFancyFormatter: (String, String) -> String = { first, last ->
        "$last, $first"
    }
    funcHigherOrderChallengePrintFormattedName(
        "Harry",
        "Potter",
        higherOrderChallengeBasicFormatter
    ) // output: Formatted name is Potter, Harry
    funcHigherOrderChallengePrintFormattedName(
        "Harry",
        "Potter",
        higherOrderChallengeFancyFormatter
    ) // output: Formatted name is Harry Potter


    /******** Control Flow Structures ********/
    if (mutableVar > 3) println("$mutableVar is greater than 3")
    else println("mutableVar $mutableVar is NOT greater than 3")

    when {
        mutableVar > 3 -> println("$mutableVar is greater than 3")
        else -> println("mutableVar $mutableVar is NOT greater than 3")
    } // same logic as the if/else above

    mutableVar += 1
    when (mutableVar) {
        0, 1 -> println("The value of mutableVar is 0 or 1")
        2 -> println("The value of mutableVar is 2")
        in 3..Int.MAX_VALUE -> println("mutableVar $mutableVar is between 3 and Int.MAX_VALUE")
    }

    println(funcIfSingleExpression(mutableVar))
    println(funcWhenSingleExpression(mutableVar))


    val messageWithError = try {
        "The value is ${10 / 0}"
    } catch (error: IllegalStateException) {
        "Error was IllegalState"
    } catch (error: ArithmeticException) {
        "Error was ArithmeticException" // output is this
    }
    println(messageWithError)


    val genericVal: Any = 5
    funcSmartCastingCheckType(genericVal)
    // example of casting
    // val intVal: Int = genericVal as Int

    var counterWhile = 0
    while (counterWhile < 5) {
        print("$counterWhile ")
        counterWhile++
        if (counterWhile == 3) break
    } // output: 0 1 2
    println()


    var counterDoWhile = 0
    do {
        print("$counterDoWhile ")
        counterDoWhile += 1
    } while (counterDoWhile < 3)
    // output: 0 1 2
    // same logic as the while loop above

    println()
    for (counter in 0 until 5) {
        print("$counter ")
    } // output: 0 1 2 3 4
    println()
    for (counter in 10 downTo 0 step 2) {
        print("$counter ")
    } // output: 10 8 6 4 2 0

    println()
    // challenge: replace an if/else expression with a when expression
    println(funcWhenExpressionChallenge(null))
    println(funcWhenExpressionChallenge(4))
    println(funcWhenExpressionChallenge(3.2))
    println(funcWhenExpressionChallenge("Hello Kotlin"))
    println(funcWhenExpressionChallenge('a'))


    /******** Working with Collections ********/
    // arrays
    val arrayInt = arrayOf(100, 200, 300, 400, null)
    val arraySetSize = arrayOfNulls<Int>(5)
    val arrayCustom = Array(5) { index -> index }

    arrayInt.size // size of array
    arrayInt.get(0) // get the value of the 1st element; same as arrayInt[0]
    arrayInt.set(4, 500) // set the value of 5th element; same as arrayInt[4] = 500

    val primitiveInt = intArrayOf(1, 2, 3, 4, 5)

    funcArrayGreet("Hi", "Rick", "Morty", "Summer", "Beth")


    // by default, list is immutable
    val listString: List<String> = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
    val emptyList: List<String> = emptyList()

    listString.size // size of list
    listString.get(0) // get the value of the 1st element; same as listString[0]

    // mutable list
    val listMutable = mutableListOf("Kotlin", "Java")
    listMutable.add(1, "C++") // add in specific spot
    println(listMutable.size) // output: 3
    listMutable.removeAt(0) // remove specific spot


    // set does not allow duplicate elements
    val setAnimals = setOf("dog", "cat")
    setAnimals.size
    println(setAnimals.contains("bird")) // output: false


    // map
    val mapTestScores = mutableMapOf(
        Pair(100, "Pass"),
        Pair(50, "Borderline"),
        30 to "Fail"
    )

    println(mapTestScores[100]) // output: Pass

    for (pair in mapTestScores) {
        println("Score of ${pair.key} is ${pair.value}")
    }
    for ((score, remark) in mapTestScores) {
        println("Score of $score is $remark")
    } // same logic as the code above

    // need to change to mutableMapOf before adding
    mapTestScores[0] = "Retake the test"

    // sequences do the minimal number of operations (compared to iterables)
    val sequenceMonths = sequenceOf("January", "February", "March")

    // challenge: filtering a list of data - print out the 3 student IDs with the lowest test scores
    val challengeTestScores = mapOf(
        "123abc" to 88.1,
        "124xyz" to 88.9,
        "345abc" to 82.1,
        "345bbc" to 72.1,
        "34efbc" to 66.1,
        "345abc" to 89.1,
        "385agc" to 62.1,
        "837abc" to 85.7,
        "9459bc" to 94.3,
        "nd2192" to 83.8,
    )

    challengeTestScores.toList()
        .sortedBy { pair -> pair.second } // access the 'second' which is the value; sort by test score
        .map { pair -> pair.first } // map to 'first', which is the student id
        .take(3) // take the first 3
        .forEach { println(it) }


    /******** Working with Inputs and Outputs ********/
    // see other notes: NotesIOExternal.kt and NotesIOUser.kt

    // added a new file: scores.txt
    val scoresFile = File("src/main/kotlin/scores.txt")
    scoresFile.forEachLine { line -> println(line) }
    val sortedLines = scoresFile.readLines().sorted()
    val outputFile = File("src/main/kotlin/sortedScores.txt").toPath()
    outputFile.writeLines(sortedLines)

    // challenge: parsing a list of data from a file
    // find the highest test scores from a file, prompt the user to enter the input filename
    // sort the scores, locate the highest three, write in output file
    print("Enter the filename for the challenge: ") // input should be src/main/kotlin/scores.txt
    val challengeInputFilename = readLine()
    if (challengeInputFilename.isNullOrEmpty()) {
        println("The challenge file was null!")
        return
    }
    val challengeInputFile = File(challengeInputFilename)
    if (!challengeInputFile.isFile) return
    val challengeRawScores = challengeInputFile.readLines()
    val challengeParsedScores = challengeRawScores.map { line ->
        val elements = line.split(":")
        elements[0] to elements[1]
    }
    val challengeHighest = challengeParsedScores.sortedByDescending { it.second }
        .take(3)
    val challengeOutputFile = File("src/main/kotlin/challengeHighestScores.txt").toPath()
    val challengeOutputScores = challengeHighest.map {
        "${it.first}:${it.second}"
    }
    challengeOutputFile.writeLines(challengeOutputScores)
}

/******** end of main() ********/

fun funcWithStringReturn(): String {
    return "Princess Bubblegum";
}

fun funcSingleExpression() = "Single expression function"

fun funcWithPrint() = println("Hello, you!")

fun funcWithParam(name: String) = println("Hello, $name!")

fun funcIncrementByOne(increment: Int = 1, number: Int): Int {
    return increment + number
}

// functional types
// take note of "var"
var funcFunctionalType: () -> Unit = {
    println("Hello, Kotlin!")
}

var funcFunctionalTypeWithExplicitNaming: (String) -> String = { explicitName ->
    "Hello, $explicitName!"
}

// higher-order functions
// take note of "fun"
fun funcHigherOrder(
    value1: Int, value2: Int,
    funcCalculator: (Int, Int) -> Int
) {
    println("The calculated value is ${funcCalculator(value1, value2)}")
}

fun funcHigherOrderChallengePrintFormattedName(
    first: String, last: String,
    funcFormatter: (String, String) -> String
) {
    println("Formatted name is ${funcFormatter(first, last)}")
}


fun funcIfSingleExpression(param: Int) =
    if (param > 3) {
        "Param is greater than 3"
    } else {
        "Param is NOT greater than 3" // output is this
    }

fun funcWhenSingleExpression(param: Int) = when (param) {
    3 -> "Param is 3" // output is this
    else -> "Param is NOT 3"
}

fun funcSmartCastingCheckType(input: Any?) { // added ? so null can be passed
    when (input) {
        null -> println("Input is null")
        is String -> println("Input is String")
        !is String -> println("Input is not String")
    }
    // same logic as above
    /** if (input is String?) {
    if (input == null) println("The input is null")
    else println("The input is a string with the length of ${input.length}")
    }
    if (input !is String) println("The input is NOT a string")**/
}

fun funcWhenExpressionChallenge(input: Any?): String = when (input) {
    is Number -> {
        if (input !is Int) "Input is an int number"
        else "Input is a non-int number"
    }

    is String -> "Input is String with length ${input.length}"
    null -> "Input is null"
    else -> "Input didn't match target inputs"
}


fun funcArrayGreet(greeting: String, vararg names: Any) {
    for (name in names) {
        println("$greeting, $name!")
    }
}