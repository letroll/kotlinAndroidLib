package com.vlad.android.kotlin

import android.view.View
import android.app.Activity
import android.view.View.OnClickListener
import android.view.MotionEvent
import android.view.View.OnTouchListener

public inline fun View.findView<T: View>(id: Int): T? = findViewById(id) as? T

public inline fun OnTouchListener(action: (View?, MotionEvent?) -> Boolean): OnTouchListener {
    return object : OnTouchListener {
        override fun onTouch(v: View?, event: MotionEvent) = action(v, event)
    }
}

public inline fun OnClickListener(action: (View?) -> Unit): OnClickListener {
    return object : OnClickListener {
        override fun onClick(v: View) = action(v)
    }
}

public inline fun View.setOnClickListener(action: (View?) -> Unit) {
    setOnClickListener(OnClickListener(action))
}

public inline fun View.setOnTouchListener(action: (View?, MotionEvent?) -> Boolean) {
    setOnTouchListener(OnTouchListener(action))
}