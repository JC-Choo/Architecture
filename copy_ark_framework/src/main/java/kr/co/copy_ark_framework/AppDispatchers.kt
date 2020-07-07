@file:Suppress("MemberVisibilityCanBePrivate", "unused", "RedundantVisibilityModifier")

package kr.co.copy_ark_framework

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executor
import java.util.concurrent.Executors

public object AppDispatchers {

    /**
     * UI 관련 작업을 할 때 사용한다.
     */
    public val UI: CoroutineDispatcher = Dispatchers.Main

    /**
     * 비교적 짧은 background 작업을 할 때 사용한다.
     */
    public val Default: CoroutineDispatcher = Dispatchers.Default

    /**
     * background data fetch (파일 읽기, API 등)의 작업이 필요할 때 사용한다.
     */
    public val IO: CoroutineDispatcher = Dispatchers.IO

    /**
     * Data tracking 의 작업이 필요할 때 사용한다.
     */
    public val Track: CoroutineDispatcher by lazy {
        AppExecutors.Track.asCoroutineDispatcher()
    }
}

/**
 * Application 전역 [Executor] 풀.
 * 각 [Executor]는 [AppDispatchers]의 [kotlinx.coroutines.CoroutineDispatcher]와 같은 thread 에서 동작한다.
 *
 * - [Executor] 보다는 [kotlinx.coroutines.CoroutineDispatcher]을 사용하는 것을 권장한다.
 * - [AppExecutors]는 외부 라이브러리에서 요구할 때 사용하는 용도로 쓰도록 한다.
 */
public object AppExecutors {

    /**
     * UI 관련 작업을 할 때 사용한다.
     */
    public val UI: Executor = UiThreadExecutor()

    /**
     * 비교적 짧은 background 작업이 필요할 때 사용한다.
     */
    public val Default: Executor by lazy {
        val cpuCount = Runtime.getRuntime().availableProcessors()
        Executors.newFixedThreadPool(cpuCount.coerceAtLeast(2))
    }

    /**
     * background data fetch (파일 읽기, API 등)의 작업이 필요할 때 사용한다.
     */
    public val IO: Executor by lazy {
        Executors.newCachedThreadPool()
    }

    /**
     * Data tracking 작업이 필요할 때 사용한다.
     */
    public val Track: Executor by lazy {
        Executors.newFixedThreadPool(2)
    }
}

/**
 * UI Thread 용 Executor
 * - UI Thread 상에서 비동기 처리 필요시 사용한다
 * - 해당 Executor 대신 Coroutine 을 사용을 권장함
 */
internal class UiThreadExecutor : Executor {

    private  val mainThreadHandler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        mainThreadHandler.post(command)
    }
}