package com.vlad.android.kotlin

import android.widget.TextView
import android.view.KeyEvent
import android.widget.TextView.OnEditorActionListener

public inline fun OnEditorActionListener(action: (TextView?, Int, KeyEvent?) -> Boolean): OnEditorActionListener {
    return object : OnEditorActionListener {
        override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?) = action(v, actionId, event)
    }
}

public inline fun TextView.setOnEditorActionListener(action: (TextView?, Int, KeyEvent?) -> Boolean) {
    setOnEditorActionListener(OnEditorActionListener(action))
}
