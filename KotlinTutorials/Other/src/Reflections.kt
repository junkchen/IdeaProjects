package junkchen
import kotlin.reflect.jvm.jvmName

/**
 * Reflection
 */

class MyClass

fun isOdd(x: Int) = x % 2 != 0

fun main(args: Array<String>) {
    // class references
    println("""qualifiedName: ${MyClass::class.qualifiedName}
            simpleName: ${MyClass::class.simpleName}
            jvmName: ${MyClass::class.jvmName}""".trimStart(' '))

    // function references
    val numbers = listOf(1, 2, 3, 4, 5)
    println(numbers.filter(::isOdd))

    
}
