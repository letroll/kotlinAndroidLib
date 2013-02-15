package com.vlad.android.kotlintest

import com.vlad.android.kotlin.IntentFilter
import android.content.Intent
import kotlin.test.assertEquals
import android.test.AndroidTestCase
import android.widget.LinearLayout
import android.widget.TextView
import com.vlad.android.kotlin.*
import kotlin.test.assertTrue
import android.view.View.OnClickListener
import android.view.View.OnTouchListener
import org.mockito.Mockito.*
import org.mockito.Mockito
import android.view.MotionEvent

public class KotlinViewTest() : AndroidTestCase() {
  public fun testFindView() {
    val linearLayout = LinearLayout(getContext())
    val view = TextView(getContext())
    view.setId(100)
    linearLayout.addView(view)
    val textView = linearLayout.findView<TextView>(100)
    assertEquals(view, textView)
  }

  public fun testOnTouchListener() {
    val onTouchListener = OnTouchListener { view, motionEvent -> true }
    assertTrue(onTouchListener is OnTouchListener)
  }

  public fun testOnClickListener() {
    val onClickListener = OnClickListener { view -> }
    assertTrue(onClickListener is OnClickListener)
  }

  public fun testSetOnClickListener() {
    val spy = spy(SpyClass("abcde"))
    val view = TextView(getContext())
    view.setOnClickListener { view -> spy?.test() }
    view.callOnClick()
    verify(spy, times(1))?.test()
  }

  public fun testSetOnTouchListener() {
    val spy = spy(SpyClass("abcde"))
    val view = TextView(getContext())
    view.setOnTouchListener { view, motionEvent ->
      spy?.test()
      true
    }
    view.dispatchTouchEvent(MotionEvent.obtain(1,1,MotionEvent.ACTION_DOWN,1.0,1.0,1))
    verify(spy, times(1))?.test()
  }
}

public open class SpyClass(text : String) {
  val text = text
  public open fun test() : Int = text.length()
}

