package com.vlad.android.kotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

public inline fun BroadcastReceiver(init: (Context, Intent) -> Unit): BroadcastReceiver {
    return object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            init(context, intent)
            throw UnsupportedOperationException()
        }
    }
}
