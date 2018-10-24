/**
 * Extension 扩展
 */
fun main(args: Array<String>) {
    printFoo(D())
}

open class C

class D: C()

fun C.foo() = "c"

fun D.foo() = "d"

fun printFoo(c: C) {
    println(c.foo())
}
