/**
 * Classes and Inheritance
 * 关键字：class
 * 组成：类名(class name)、类头(class header)、类体(class body)以及大括号(curly braces)，
 * 类头和类体是可选的，没有类体时大括号可以省略。
 * 构造方法有 primary 和 secondary 两种，主构造方法的初始化在 init 代码块中
 * 默认 public ，要私有需指定为 private
 *
 * Inheritance 继承
 * 所有类的默认超类是 Any
 */
class Invoice{/**/}
class Empty

open class Base(val name: String) {
    init {
        println("Initializing Base")
    }

    open val size: Int =
            name.length.also { println("Initializing size in Base: $it") }
}

class Derived(name: String,
              val lastName: String) : Base(name) {
    init {
        println("Initializing Derived")
    }

    override val size: Int =
            (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

fun main(args: Array<String>) {
    println("Constructing Derived(\"Hello\", \"World\")")
    Derived("Hello", "World")
}