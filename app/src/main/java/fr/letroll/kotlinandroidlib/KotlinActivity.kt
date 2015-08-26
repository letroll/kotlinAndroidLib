package fr.letroll.kotlinandroidlib

import android.app.Activity
import android.view.View

public fun Activity.findView<T: View>(id: Int): T? = findViewById(id) as? T

public fun Activity.runOnUiThread(action: () -> Unit): Unit {
    runOnUiThread(Runnable(action))
}
