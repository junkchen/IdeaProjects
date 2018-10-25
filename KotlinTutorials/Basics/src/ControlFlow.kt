/**
 * Control Flow:
 * if, when, for, while
 *
 */
fun main(args: Array<String>) {
    for (i in 1..3) {  // [1, 3]
        println(i)
    }
    println("----------")
    for (i in 3 downTo 1) {  // [3, 1]
        println(i)
    }
    println("----------")
    for (i in 1 until 3) {  // [1, 3) not contain 3
        println(i)
    }
}

/**
 * if expression
 */
fun ifExpression() {
    val a = 2
    val b = 5

    // Traditional usage
    var max = a
    if (a < b) max = b

    // with else
    var max2: Int
    if (a > b) {
        max2 = a
    } else {
        max2 = b
    }

    // as expression
    val max3 = if (a > b) a else b

    // block, last expression is the value of a block
    val max4 = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }
}
