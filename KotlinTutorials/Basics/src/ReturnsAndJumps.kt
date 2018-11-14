/**
 * return, break, continue
 * label: ef:  return label@
 */
fun main(args: Array<String>) {
//    foo()
    returnTest()
}

fun foo() {
//    listOf(1, 2, 3, 4, 5).forEach lit@{
//        if (it == 3) return@lit
//        print(it)
//    }

//    listOf(1, 2, 3, 4, 5).forEach {
//        if (it == 3) return@forEach
//        print(it)
//    }
//    print(" done with explicit label")

    println("-*-*-*--*-*-*--*-*-*--*-*-*--*-*-*--*-*-*-")

    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return
        print(value)
    })
    print(" done with anonymous function")

    println("\n-*-*-*--*-*-*--*-*-*--*-*-*--*-*-*--*-*-*-")

    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop
            print(it)
        }
        print(" done with nested loop")
    }
}

fun returnTest() {
    var str : String? = null
//    str = "non null str"
    println("start")
    str?.let {
        println(str)
        return
    }
    println("end")
}
