package uz.ttpu.seminar1_2_3

// ============================================================================
// PART II — KOTLIN INTERMEDIATE (SEMINAR 1 EXERCISES)
// ============================================================================

// ----------------------------------------------------------------------------
// 10. Extension Functions
// ----------------------------------------------------------------------------

// Exercise 10.1 — String.shout() [Warm-up]
// Extension function that returns string uppercased with "!!!" appended.
fun String.shout(): String = this.uppercase() + "!!!"

// Exercise 10.2 — Int.isPrime() [Core]
// Extension function to check if an integer is prime.
fun Int.isPrime(): Boolean {
    if (this < 2) return false
    for (i in 2 until this) {
        if (this % i == 0) return false
    }
    return true
}

// Helper function to get prime numbers in range 2..20
fun getPrimesInRange(): List<Int> {
    val primes = mutableListOf<Int>()
    for (n in 2..20) {
        if (n.isPrime()) {
            primes.add(n)
        }
    }
    return primes
}

// ----------------------------------------------------------------------------
// 11. Scope Functions — let, apply, run, also, with
// ----------------------------------------------------------------------------

// Data structure for Book
class Book(var title: String = "", var author: String = "", var pages: Int = 0)

// Exercise 11.1 — Safe print with let [Warm-up]
fun safePrintWithLet(maybeName: String?): String? {
    return maybeName?.let {
        it.uppercase()
    }
}

// Exercise 11.2 — Configure with apply [Core]
fun createBookWithApply(): Book {
    return Book().apply {
        title = "Kotlin in Action"
        author = "Dmitry Jemerov"
        pages = 360
    }
}

// Exercise 11.3 — Log creation with also [Core]
fun createBookWithAlso(): Book {
    return Book(title = "Atomic Habits", author = "James Clear", pages = 320).also {
        println("Created book: ${it.title}")
    }
}

// Exercise 11.4 — let vs. apply vs. also [Challenge]
fun demoScopeFunctionsComparison(): String {
    // 1. Using let:
    val b1 = Book(title = "Sample", author = "Someone", pages = 0).let {
        it.pages = 400
        it
    }

    // 2. Using apply:
    val b2 = Book(title = "Sample", author = "Someone", pages = 0).apply {
        pages = 400
    }

    // 3. Using also:
    val b3 = Book(title = "Sample", author = "Someone", pages = 400).also {
        println("Logging book creation: ${it.title}")
    }

    return "b1 pages: ${b1.pages}, b2 pages: ${b2.pages}, b3 pages: ${b3.pages}\n" +
            "Best fit: 'apply' — it is specifically designed for object initialization and property configuration."
}

// ----------------------------------------------------------------------------
// 12. Lambda Expressions with Receiver
// ----------------------------------------------------------------------------

// Exercise 12.1 — buildGreeting with StringBuilder receiver [Core]
fun buildGreeting(action: StringBuilder.() -> Unit): String {
    val builder = StringBuilder()
    builder.action()
    return builder.toString()
}

// ----------------------------------------------------------------------------
// 13. Classes and Interfaces
// ----------------------------------------------------------------------------

// Exercise 13.1 — Shape hierarchy with an abstract class [Core]
abstract class AbstractShape {
    abstract fun area(): Double
    fun describe(): String = "This shape has an area of ${area()}"
}

class AbstractCircle(val radius: Double) : AbstractShape() {
    override fun area(): Double = Math.PI * radius * radius
}

class AbstractRectangle(val width: Double, val height: Double) : AbstractShape() {
    override fun area(): Double = width * height
}

// Exercise 13.2 — Same hierarchy with an interface [Challenge]
interface InterfaceShape {
    fun area(): Double
    fun describe(): String = "This shape has an area of ${area()}"
}

class InterfaceCircle(val radius: Double) : InterfaceShape {
    override fun area(): Double = Math.PI * radius * radius
}

class InterfaceRectangle(val width: Double, val height: Double) : InterfaceShape {
    override fun area(): Double = width * height
}

/*
 * Exercise 13.2 Comparison Comment:
 * Lost: Interfaces cannot hold constructor parameters or backing field states (unlike abstract classes).
 * Gained: Classes implementing interfaces can implement multiple interfaces simultaneously,
 * whereas Kotlin only supports single-class inheritance.
 */

// ----------------------------------------------------------------------------
// 14. Objects — Declarations, Data Objects, Companion Objects
// ----------------------------------------------------------------------------

// Exercise 14.1 — AppConfig singleton [Warm-up]
object AppConfig {
    val appName = "GradeBook"
    var isDebug = false

    fun toggleDebug() {
        isDebug = !isDebug
    }
}

// Exercise 14.2 — Companion object factory [Core]
class User private constructor(val name: String) {
    companion object {
        fun create(name: String): User = User(name)
    }
}

// ----------------------------------------------------------------------------
// 15. Open and Special Classes
// ----------------------------------------------------------------------------

// Exercise 15.1 — Vehicle -> Car [Core]
open class Vehicle(val make: String, val model: String) {
    open fun honk(): String = "Beep!"
}

class Car(make: String, model: String, val numberOfDoors: Int) : Vehicle(make, model) {
    override fun honk(): String = "Honk honk!"
}

// ----------------------------------------------------------------------------
// EXECUTION DEMO / SUMMARY FUNCTION
// ----------------------------------------------------------------------------
fun runSeminar1Demos(): String {
    val sb = StringBuilder()

    sb.appendLine("=== 10. Extension Functions ===")
    sb.appendLine("10.1 shout(): 'hello'.shout() -> ${"hello".shout()}")
    sb.appendLine("10.1 shout(): 'kotlin is fun'.shout() -> ${"kotlin is fun".shout()}")
    sb.appendLine("10.2 Primes 2..20: ${getPrimesInRange().joinToString(", ")}")

    sb.appendLine("\n=== 11. Scope Functions ===")
    sb.appendLine("11.1 let: safePrintWithLet(\"Amin\") -> ${safePrintWithLet("Amin")}")
    val bookApply = createBookWithApply()
    sb.appendLine("11.2 apply: Book -> Title: ${bookApply.title}, Author: ${bookApply.author}, Pages: ${bookApply.pages}")
    val bookAlso = createBookWithAlso()
    sb.appendLine("11.3 also: Created Book -> ${bookAlso.title}")
    sb.appendLine("11.4 Comparison:\n${demoScopeFunctionsComparison()}")

    sb.appendLine("\n=== 12. Lambda with Receiver ===")
    val greeting = buildGreeting {
        append("Hello, ")
        append("class! ")
        append("Welcome to Kotlin.")
    }
    sb.appendLine("12.1 buildGreeting -> $greeting")

    sb.appendLine("\n=== 13. Classes and Interfaces ===")
    val circleAbs = AbstractCircle(2.0)
    val rectAbs = AbstractRectangle(3.0, 4.0)
    sb.appendLine("13.1 Abstract Shape Circle: ${circleAbs.describe()}")
    sb.appendLine("13.1 Abstract Shape Rectangle: ${rectAbs.describe()}")

    val circleIf = InterfaceCircle(2.0)
    val rectIf = InterfaceRectangle(3.0, 4.0)
    sb.appendLine("13.2 Interface Shape Circle: ${circleIf.describe()}")
    sb.appendLine("13.2 Interface Shape Rectangle: ${rectIf.describe()}")

    sb.appendLine("\n=== 14. Objects ===")
    sb.appendLine("14.1 AppConfig appName: ${AppConfig.appName}, isDebug initially: ${AppConfig.isDebug}")
    AppConfig.toggleDebug()
    sb.appendLine("14.1 AppConfig isDebug after toggleDebug(): ${AppConfig.isDebug}")
    val user = User.create("Amin")
    sb.appendLine("14.2 User Companion Object Factory: user.name -> ${user.name}")

    sb.appendLine("\n=== 15. Open and Special Classes ===")
    val car = Car("Chevrolet", "Cobalt", 4)
    sb.appendLine("15.1 Vehicle/Car: ${car.make} ${car.model} (${car.numberOfDoors} doors) honk -> ${car.honk()}")

    return sb.toString()
}
