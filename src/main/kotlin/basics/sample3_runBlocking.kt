package basics

import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch { // launch new coroutine in background and continue
        delay(1000L)
        println("World!")
    }
    println("Hello,") // basics.main thread continues here immediately
    runBlocking {     // but this expression blocks the basics.main thread
        delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
    }
}