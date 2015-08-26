package fr.letroll.kotlinandroidlib

import android.content.IntentFilter

public fun IntentFilter(body: IntentFilter.() -> Unit): IntentFilter {
    val intentFilter = IntentFilter()
    intentFilter.body()
    return intentFilter
}
