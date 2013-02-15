package com.vlad.android.kotlintest

import kotlin.test.assertEquals
import kotlin.test.assertTrue
import junit.framework.TestCase
import com.vlad.android.kotlin.*
import android.widget.TextView.OnEditorActionListener
import kotlin.test.assertNull
import android.widget.TextView
import android.test.AndroidTestCase

public class KotlinTextViewTest() : AndroidTestCase() {
  public fun testDialogOnClickListener() {
    val onEditorActionListener = OnEditorActionListener { textView, actionId, keyEvent -> true }
    assertTrue(onEditorActionListener is OnEditorActionListener)
  }

  public fun testSetOnEditorActionListener() {
    val textView = TextView(getContext())
    assertTrue(textView.setOnEditorActionListener {textView, actionId, keyEvent -> true } is Unit)
  }
}