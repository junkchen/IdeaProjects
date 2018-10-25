import jdk.nashorn.internal.runtime.regexp.JoniRegExp

/**
 * Higher-Order Function
 * (A, B) -> C 表示一个函数类型，有两个参数，参数类型是 A，B，返回值类型是 C，
 * 没有参数时是，() -> C ，如果返回值是 Unit，是不能省略的。
 */

fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R  // function-type (R, T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

fun main(args: Array<String>) {
    val items = listOf(1, 2, 3, 4, 5)

    // Lambdas are code blocks enclosed in curly braces.
    items.fold(0, {
        // When a lambda has parameters, they go first, followed by '->'
        acc: Int, i: Int ->
        println("acc = $acc, i = $i")
        val result = acc + i
        println("result: $result")
        result  // // The last expression in a lambda is considered the return value:
    })

    // Parameter types in a lambda are optional if they can be inferred:
    val joinToString = items.fold("Element:", {acc, i -> acc + " " + i})
    println(joinToString)

    // Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)
    println("product: $product")


}