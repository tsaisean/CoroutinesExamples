import kotlinx.coroutines.*
import utils.log

fun main() = runBlocking<Unit> {
    // launch a coroutine to process some kind of incoming request
    val request = launch {
        // it spawns two other jobs, one with GlobalScope
        GlobalScope.launch {
            log("job1: I run in GlobalScope and execute independently!")
            delay(1000)
            log("job1: I am not affected by cancellation of the request")
        }
        // and the other inherits the parent context
        launch {
            delay(100)
            log("job2: I am a child of the request coroutine")
            delay(1000)
            log("job2: I will not execute this line if my parent request is cancelled")
        }
    }
    delay(500)
    request.cancel() // cancel processing of the request
    delay(1000) // delay a second to see what happens
    log("main: Who has survived request cancellation?")
}