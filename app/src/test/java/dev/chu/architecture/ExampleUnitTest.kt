package dev.chu.architecture

import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testCoroutine01() {
        runBlocking {
            println("Start")
            CoroutineScope(Dispatchers.IO).launch {
                println("A Scope : I'am CoroutineScope, start!")
                for(item in 0 .. 100) {
                    println("A Scope : $item")
                }
            }

            CoroutineScope(Dispatchers.IO).launch {
                println("B Scope : I'am CoroutineScope, start!")
                for(item in 0 .. 100) {
                    println("B Scope : $item")
                }
            }
        }

        /**
         * runBlocking : 내부 로직이 끝날 동안 외부에게 기다리도록 하게 한다.
         * CoroutineScope : 비동기적으로 돌아간다.
         * runBlocking 과는 별개로 또다른 쓰레드, A scope 와 B Scope 2개가 비동기적으로 돌고 있는 것
         *
         * 따라서 CoroutineScope의 종료는 테스트 코드 런타임의 관심밖이므로 runBlocking의 내부 로직이 마친 직후에
         * 런타임이 종료가 되면 해당 프로세스는 종료되기 때문에 "A와 B 모두 정상 출력이 보장되지 못 한다."
         */
    }

    @Test
    fun testCoroutine02() {
        runBlocking {
            println("Start")
            val job = CoroutineScope(Dispatchers.IO).async {
                println("A Scope : I'am CoroutineScope, start!")
                for(item in 0 .. 100) {
                    println("A Scope : $item")
                }
            }

            CoroutineScope(Dispatchers.IO).launch {
                println("B Scope : I'am CoroutineScope, start!")
                for(item in 0 .. 100) {
                    println("B Scope : $item")
                }
            }
            job.await()
        }
    }
}
