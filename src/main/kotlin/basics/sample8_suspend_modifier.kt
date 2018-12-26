package basics

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        doWorld()
        println("Sean,")
    }
    println("Hello,")
}

// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}