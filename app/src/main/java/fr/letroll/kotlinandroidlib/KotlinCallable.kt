package fr.letroll.kotlinandroidlib

import java.util.concurrent.Callable

public fun callable<T>(action: () -> T): Callable<out T> {
    return object : Callable<T> {
        public override fun call(): T = action()
    }
}
