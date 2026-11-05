// Kotlin Practice Exercises — Fundamentals (Lecture 2)
// Run this file to see the examples for exercises 1–9.

fun main() {
    println("=== 1. Variables: val and var ===")
    sensorLog()
    vendingMachine()

    println("\n=== 2. String templates ===")
    orderConfirmation()
    printReceipt("Kotlin Mug", 12)
    printReceipt("Kotlin Sticker Pack", 5)

    println("\n=== 3. Basic types and type inference ===")
    println("9 / 4 = ${9 / 4} (Int)")
    println("9.0 / 4 = ${9.0 / 4} (Double)")
    println("9 % 4 = ${9 % 4} (Int)")
    println("9 / 4.0 = ${9 / 4.0} (Double)")
    println("2 + 3 * 5 = ${2 + 3 * 5} (Int)")
    println("(2 + 3) * 5 = ${(2 + 3) * 5} (Int)")

    println("\n=== 4. Collections ===")
    playlist()
    cafeMenu()
    attendance()

    println("\n=== 5. Control flow ===")
    grades()
    countdown()
    pinEntry()
    fizzBuzz()

    println("\n=== 6. Functions ===")
    notifications()
    println("Absolute value: ${absoluteValue(-12)}")
    filteringScores()
    println("Digit sum of 1234: ${digitSum(1234)}")
    println("Digit sum of 507: ${digitSum(507)}")

    println("\n=== 7. Classes ===")
    bookExamples()
    studentAverages()

    println("\n=== 8. Null safety ===")
    nicknameLength()
    println(describeString("Kotlin"))
    println(describeString(""))
    println(describeString(null))
    println(describeStringWithElvis("Kotlin"))
    firstValidReading()

    println("\n=== 9. Naming conventions ===")
    println("Variables: userName, isLoggedIn")
    println("Function: getUserName()")
    println("Class: Circle")
    println("Constants: MAX_RETRIES, PI, DEFAULT_TIMEOUT")
}

private fun sensorLog() {
    val city: String = "Tashkent"
    var temperature: Double = 18.5
    temperature = 19.0
    println("$city temperature: $temperature°C")
    // city = "Samarkand" // Error: "Val cannot be reassigned"
}

private fun vendingMachine() {
    val price = 3000
    var stock = 10
    var totalCollected = 0

    repeat(3) { purchaseNumber ->
        stock -= 1
        totalCollected += price
        println("Purchase ${purchaseNumber + 1}: Stock: $stock, Total collected: $totalCollected")
    }
    println("Grand total collected: $totalCollected")
}

private fun orderConfirmation() {
    val customer = "Diyor"
    val total = 145000
    println("Hi $customer, your order of $total so'm is confirmed.")
    println("Free delivery: ${if (total >= 100000) "Yes" else "No"}")
}

private fun printReceipt(item: String, price: Int) {
    val receipt = """
        Item: "$item"
        Price: $$$price
        Thank you for your purchase!
    """.trimIndent()
    println(receipt)
}

private fun playlist() {
    val defaultPlaylist = listOf("Song A", "Song B", "Song C", "Song D", "Song E")
    println("Default playlist: $defaultPlaylist")
    // defaultPlaylist.add("Song F")
    // Error: "Unresolved reference: add" — a read-only List has no add() function.

    val likedSongs = mutableListOf<String>()
    likedSongs.add("Song A")
    likedSongs.add("Song C")
    likedSongs.add("Song F")
    println("Liked songs: $likedSongs")
}

private fun cafeMenu() {
    val menu = mapOf("Coffee" to 15000, "Tea" to 10000, "Croissant" to 12000, "Bagel" to 18000)
    for ((name, price) in menu) println("$name costs $price")
    println("Total menu price: ${menu.values.sum()}")
    val cheapest = menu.minByOrNull { it.value }
    val priciest = menu.maxByOrNull { it.value }
    println("Cheapest: ${cheapest?.key}, Priciest: ${priciest?.key}")
}

private fun attendance() {
    val signIns = listOf("Aziz", "Nodira", "Aziz", "Bekzod", "Nodira", "Aziz")
    val uniqueStudents: Set<String> = signIns.toSet()
    val attendance: Map<String, Boolean> = uniqueStudents.associateWith { true }
    println(attendance)
    println("Present: ${attendance.size} students")
}

private fun grades() {
    val score = 85
    val grade = when {
        score >= 90 -> "A"
        score >= 80 -> "B"
        score >= 70 -> "C"
        score >= 60 -> "D"
        else -> "F"
    }
    println("Score $score: grade $grade")
}

private fun countdown() {
    for (number in 25 downTo 0 step 5) println(number)
    println("Liftoff!")
}

private fun pinEntry() {
    val attempts = listOf(1111, 4321, 9999)
    val correctPin = 4321
    var index = 0
    var unlocked = false

    while (index < attempts.size && !unlocked) {
        if (attempts[index] == correctPin) {
            unlocked = true
        } else {
            println("Wrong PIN: ${attempts[index]}")
        }
        index++
    }
    println(if (unlocked) "Card unlocked" else "Card locked")
    // A do-while always runs once. With an empty list, attempts[0] would throw
    // IndexOutOfBoundsException before the loop gets a chance to check its condition.
}

private fun fizzBuzz() {
    for (number in 1..30) {
        val output = when {
            number % 15 == 0 -> "FizzBuzz"
            number % 3 == 0 -> "Fizz"
            number % 5 == 0 -> "Buzz"
            else -> number.toString()
        }
        println(output)
    }
}

private fun notifications() {
    println(notify("Server restarted"))
    println(notify("Server restarted", "SMS"))
    println(notify(channel = "Push", message = "Server restarted"))
}

private fun notify(message: String, channel: String = "Email"): String = "[$channel] $message"

private fun absoluteValue(x: Int): Int = if (x < 0) -x else x

private fun isPassing(score: Int): Boolean = score >= 60

private fun filteringScores() {
    val scores = listOf(45, 60, 82, 59, 91, 60, 33)
    val passingScores = scores.filter { isPassing(it) }
    println("Passing scores: $passingScores")
}

private fun digitSum(n: Int): Int {
    var remaining = n
    var sum = 0
    while (remaining > 0) {
        sum += remaining % 10
        remaining /= 10
    }
    return sum
}

private data class Book(val title: String, val author: String, val pages: Int)

private fun bookExamples() {
    val book1 = Book("Atomic Habits", "James Clear", 320)
    val book2 = Book("Kotlin in Action", "Dmitry Jemerov", 360)
    println("${book1.title} by ${book1.author}")
    println("${book2.title} by ${book2.author}")

    val sameBook = Book("Atomic Habits", "James Clear", 320)
    val revisedEdition = book1.copy(pages = 340)
    println(book1)
    println("Same book? ${book1 == sameBook}")
    println("Revised edition: $revisedEdition")
}

private class Student(val name: String, val grades: List<Int>) {
    fun average(): Double = grades.sum().toDouble() / grades.size
}

private fun studentAverages() {
    val amina = Student("Amina", listOf(85, 90, 78))
    val diyor = Student("Diyor", listOf(60, 72, 68, 74))
    println("${amina.name}: ${amina.average()}")
    println("${diyor.name}: ${diyor.average()}")
}

private fun nicknameLength() {
    var nickname: String? = null
    println(nickname?.length ?: 0)
    nickname = "Shery"
    println(nickname?.length ?: 0)
}

private fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) return maybeString
    return "empty or null"
}

private fun describeStringWithElvis(maybeString: String?): String =
    maybeString?.takeIf { it.isNotEmpty() } ?: "empty or null"

private fun firstValidReading() {
    val readings: List<String?> = listOf(null, null, "23.5", "19.1", null)
    val firstValid = readings.firstOrNull { it != null } ?: "No data"
    println(firstValid)
}
