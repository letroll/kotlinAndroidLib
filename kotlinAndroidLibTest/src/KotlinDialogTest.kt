package com.vlad.android.kotlintest

import android.content.DialogInterface
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import junit.framework.TestCase
import com.vlad.android.kotlin.*
import android.app.AlertDialog.Builder

public class KotlinDialogTest() : TestCase() {

  public fun testDialogOnClickListener() {
    val onClickListener = dialogOnClickListener { dialog, which -> }
    assertTrue(onClickListener is DialogInterface.OnClickListener)
  }

  public fun testDialogOnCancelListener() {
    val onCancelListener = dialogOnCancelListener { dialog -> }
    assertTrue(onCancelListener is DialogInterface.OnCancelListener)
  }
}