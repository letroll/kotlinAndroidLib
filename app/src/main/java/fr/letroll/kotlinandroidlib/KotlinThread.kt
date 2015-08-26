package fr.letroll.kotlinandroidlib

public fun async(action: () -> Unit): Unit = Thread(runnable(action)).start()
