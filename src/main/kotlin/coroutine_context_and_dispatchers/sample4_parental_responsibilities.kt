package coroutine_context_and_dispatchers

import kotlinx.coroutines.*
import utils.log

fun main() = runBlocking<Unit> {
    // launch a coroutine to process some kind of incoming request
    val request = GlobalScope.launch {
        repeat(10) { i -> // launch a few children jobs
            launch  {
                delay((i + 1) * 200L) // variable delay 200ms, 400ms, 600ms
                log("Coroutine $i is done")
            }
        }
        log("request: I'm done and I don't explicitly join my children that are still active")
    }
    request.join() // wait for completion of the request, including all its children
    log("Now processing of the request is complete")
}