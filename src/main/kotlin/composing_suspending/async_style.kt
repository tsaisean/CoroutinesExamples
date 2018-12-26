package composing_suspending

import kotlinx.coroutines.*
import kotlin.system.*

// note, that we don't have `runBlocking` to the right of `main` in this example
fun main() {
    val time = measureTimeMillis {
        // we can initiate async actions outside of a coroutine
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()
        // but waiting for a result must involve either suspending or blocking.
        // here we use `runBlocking { ... }` to block the main thread while waiting for the result
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}

fun somethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulOne4()
}

fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo4()
}

suspend fun doSomethingUsefulOne4(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo4(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}