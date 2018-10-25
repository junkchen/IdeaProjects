/**
 * Nested and Inner classes
 *
 */

class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }
}

/**
 * inner 可以访问包含它的类的成员变量，使用也是包含它的类的实例
 */
class Outer2 {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}

interface OnClickListener {
    fun onClickListener()
}

class View {
    fun setOnClickListener(l: OnClickListener) {

    }
}

fun main(args: Array<String>) {
    println(Outer.Nested().foo())
    println(Outer2().Inner().foo())

    View().setOnClickListener(object : OnClickListener {
        override fun onClickListener() {

        }
    })
}
