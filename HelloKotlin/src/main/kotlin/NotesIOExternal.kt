// vararg args: String is added for user i/o
fun main(vararg args: String) {
    if (args.isEmpty()) {
        println("Arguments are required")
        return
    }

    // external input/arg
    // in Run > Program Arguments > add the arguments
    for (arg in args) {
        println(arg)
    }
}
