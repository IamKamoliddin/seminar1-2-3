// Kotlin Practice Exercises — Intermediate (Lecture 3)
// This file has its own main function; run it to see exercises 10–15.

fun main() {
    println("=== 10. Extension functions ===")
    println("hello".shout())
    println("kotlin is fun".shout())
    for (number in 2..20) {
        if (number.isPrime()) println("Prime: $number")
    }

    println("\n=== 11. Scope functions ===")
    safePrintName()
    configureBook()
    logNewBook()
    compareScopeFunctions()

    println("\n=== 12. Lambda with receiver ===")
    val message = buildGreeting {
        append("Hello, ")
        append("class! ")
        append("Welcome to Kotlin.")
    }
    println(message)

    println("\n=== 13. Classes and interfaces ===")
    val circle = Circle(2.0)
    val rectangle = Rectangle(3.0, 4.0)
    println(circle.describe())
    println(rectangle.describe())
    // The interface version cannot provide constructor state or backing fields.
    // It allows Circle or Rectangle to implement multiple interfaces.

    println("\n=== 14. Objects ===")
    println(AppConfig.appName)
    AppConfig.toggleDebug()
    println("Debug mode: ${AppConfig.isDebug}")
    val user = User.create("Amin")
    println("User: ${user.name}")

    println("\n=== 15. Open classes ===")
    val car = Car("Chevrolet", "Cobalt", 4)
    println("${car.make} ${car.model}, ${car.numberOfDoors} doors: ${car.honk()}")
}

private fun String.shout(): String = uppercase() + "!!!"

private fun Int.isPrime(): Boolean {
    if (this < 2) return false
    for (divisor in 2 until this) {
        if (this % divisor == 0) return false
    }
    return true
}

private fun safePrintName() {
    var maybeName: String? = "Amin"
    maybeName?.let { println(it.uppercase()) }
}

private data class Book(var title: String = "", var author: String = "", var pages: Int = 0)

private fun configureBook() {
    val book = Book().apply {
        title = "Kotlin in Action"
        author = "Dmitry Jemerov"
        pages = 360
    }
    println("Configured: ${book.title}")
}

private fun logNewBook() {
    val book = Book("Atomic Habits", "James Clear", 320).also {
        println("Created book: ${it.title}")
    }
    println("Assigned book: $book")
}

private fun compareScopeFunctions() {
    val withLet = Book("Sample", "Someone", 0).let {
        it.pages = 400
        it
    }
    println("let title: ${withLet.title}")

    val withApply = Book("Sample", "Someone", 0).apply {
        pages = 400
    }
    println("apply title: ${withApply.title}")

    val withAlso = Book("Sample", "Someone", 400).also {
        println("also title: ${it.title}")
    }
    println("also returns book: $withAlso")
    // apply reads best because it is designed for configuring an object.
}

private fun buildGreeting(action: StringBuilder.() -> Unit): String {
    val builder = StringBuilder()
    builder.action()
    return builder.toString()
}

private interface Shape {
    fun area(): Double
    fun describe(): String = "This shape has an area of ${area()}"
}

private class Circle(private val radius: Double) : Shape {
    override fun area(): Double = Math.PI * radius * radius
}

private class Rectangle(private val width: Double, private val height: Double) : Shape {
    override fun area(): Double = width * height
}

private object AppConfig {
    val appName = "GradeBook"
    var isDebug = false

    fun toggleDebug() {
        isDebug = !isDebug
    }
}

private class User private constructor(val name: String) {
    companion object {
        fun create(name: String): User = User(name)
    }
}

private open class Vehicle(val make: String, val model: String) {
    open fun honk(): String = "Beep!"
}

private class Car(make: String, model: String, val numberOfDoors: Int) : Vehicle(make, model) {
    override fun honk(): String = "Honk honk!"
}
