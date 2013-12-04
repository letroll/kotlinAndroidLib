package com.vlad.android.kotlin

import android.os.Handler
import android.os.Message

public inline fun Handler.post(action: () -> Unit): Boolean = post(runnable(action))
public inline fun Handler.postAtFrontOfQueue(action: () -> Unit): Boolean = postAtFrontOfQueue(runnable(action))
public inline fun Handler.postAtTime(uptimeMillis: Long, action: () -> Unit): Boolean = postAtTime(runnable(action), uptimeMillis)
public inline fun Handler.postDelayed(delayMillis: Long, action: () -> Unit): Boolean = postDelayed(runnable(action), delayMillis)

public inline fun Handler(handleMessage: (Message) -> Boolean): Handler {
    return Handler(object : Handler.Callback {
        override fun handleMessage(msg: Message?) = if (msg == null) false else handleMessage(msg)
    })
}
