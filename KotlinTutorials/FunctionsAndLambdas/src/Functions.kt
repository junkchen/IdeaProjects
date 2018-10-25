/**
 * Functions(函数)
 *
 */

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        result.add(t)
    }
    return result
}

fun main(args: Array<String>) {
    val a = arrayOf(1, 2, 3)
    // When we call a vararg-function, we can pass arguments one-by-one, e.g. asList(1, 2, 3), or, if we already have
    // an array and want to pass its contents to the function, we use the spread operator (prefix the array with *):
    val list = asList(-1, 0, *a, 4)
//    val list = asList(-1, 0, a, 4)  // [-1, 0, [Ljava.lang.Integer;@5e2de80c, 4]
    print(list.toString())
}