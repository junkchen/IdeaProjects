fun main(args : Array<String>) {
    var user: User? = null
    var name = user?.name ?: "default"
    var age = user?.age?.toString() ?: 1
    println("name: $name, age: $age")
    user = User("Junk Chen", 18)
    user?.name = "Junk Chen"
    user?.age = null
    name = user?.name ?: "default"
    age = user?.age ?: 2
    println("name: $name, age: $age")
}

data class User(var name: String?, var age: Int?)