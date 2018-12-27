package basics

import kotlinx.coroutines.*
import utils.log

fun main() {
    GlobalScope.launch { // launch new coroutine in background and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello,") // basics.main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block basics.main thread for 2 seconds to keep JVM alive
}