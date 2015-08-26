package fr.letroll.kotlinandroidlib

import java.util.concurrent.ExecutorService
import java.util.concurrent.Callable
import java.util.concurrent.Future

public fun ExecutorService.execute(action: () -> Unit): Unit {
    execute(Runnable(action))
}

public fun ExecutorService.submit<T>(action: () -> T): Future<out T>? {
    return submit(object : Callable<T> {
        public override fun call(): T = action()
    })
}

public fun ExecutorService.submit<T>(result: T, action: () -> Unit): Future<out T>? {
    return submit(Runnable(action), result)
}
