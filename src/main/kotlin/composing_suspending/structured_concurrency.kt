package composing_suspending

import kotlinx.coroutines.*
import kotlin.system.*

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne5() }
    val two = async { doSomethingUsefulTwo5() }
    one.await() + two.await()
}

suspend fun doSomethingUsefulOne5(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo5(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}