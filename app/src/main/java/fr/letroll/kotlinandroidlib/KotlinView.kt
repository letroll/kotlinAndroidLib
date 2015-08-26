package fr.letroll.kotlinandroidlib

import android.view.View
import android.app.Activity
import android.view.View.OnClickListener
import android.view.MotionEvent
import android.view.View.OnTouchListener

public fun View.findView<T: View>(id: Int): T? = findViewById(id) as? T

public fun OnTouchListener(action: (View?, MotionEvent?) -> Boolean): OnTouchListener {
    return object : OnTouchListener {
        public override fun onTouch(p0: View?, p1: MotionEvent?): Boolean = action(p0, p1)
    }
}

public fun OnClickListener(action: (View?) -> Unit): OnClickListener {
    return object : OnClickListener {
        public override fun onClick(p0: View?) {
            action(p0)
        }
    }
}

public fun View.setOnClickListener(action: (View?) -> Unit): Unit {
    setOnClickListener(OnClickListener(action))
}

public fun View.setOnTouchListener(action: (View?, MotionEvent?) -> Boolean): Unit {
    setOnTouchListener(OnTouchListener(action))
}