import java.io.File

fun main() {
    print("Enter a filename: ")
    val filename = readlnOrNull() ?: "" // elvis operator is used to catch if filename is null
    println("You entered $filename")

    // check if file exists within the project's root directory
    val isFound = File(filename).isFile
    if (isFound) {
        println("$filename is found in the project's root directory")
    } else {
        println("$filename is not found in the project's root directory")
    }
}
