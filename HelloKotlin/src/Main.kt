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

    var variableRefer = "The first number with added 1 is ${mutableVar+1}"
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
    funcHigherOrderChallengePrintFormattedName("Harry", "Potter", higherOrderChallengeBasicFormatter) // output: Formatted name is Potter, Harry
    funcHigherOrderChallengePrintFormattedName("Harry", "Potter", higherOrderChallengeFancyFormatter) // output: Formatted name is Harry Potter




    /******** Control Flow Structures ********/

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
fun funcHigherOrder(value1: Int, value2: Int,
                    funcCalculator: (Int, Int) -> Int) {
    println("The calculated value is ${funcCalculator(value1, value2)}")
}

fun funcHigherOrderChallengePrintFormattedName(first: String, last: String,
                                               funcFormatter: (String, String) -> String) {
    println("Formatted name is ${funcFormatter(first, last)}")
}