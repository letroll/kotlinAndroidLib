package com.vlad.android.kotlintest

import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import com.vlad.android.kotlin.*
import android.content.Intent
import android.net.Uri
import android.test.AndroidTestCase
import android.app.Service

public class KotlinIntentTest() : AndroidTestCase() {

  public fun testIntentPart1() {
    val intent = Intent { setAction(Intent.ACTION_BATTERY_OKAY) }
    assertTrue(intent is Intent)
    assertEquals(intent.getAction(), Intent.ACTION_BATTERY_OKAY)
  }

  public fun testIntentPart2() {
    val intent = Intent()
    val intent2 = Intent(intent, { setAction(Intent.ACTION_BATTERY_OKAY) })
    assertFalse(intent.getAction().equals(Intent.ACTION_BATTERY_OKAY))
    assertTrue(intent2.getAction().equals(Intent.ACTION_BATTERY_OKAY))
  }

  public fun testIntentPart3(){
    val intent = Intent(Intent.ACTION_BATTERY_OKAY, { setData(Uri.parse("http://www.google.com"))})
    assertEquals(intent.getAction(), Intent.ACTION_BATTERY_OKAY)
    assertEquals(intent.getData().toString(), "http://www.google.com")
  }

  public fun testIntentPart4() {
    val intent = Intent(getContext(), javaClass<Service>(), { setData(Uri.parse("http://www.google.com"))})
    assertEquals(intent.getData().toString(), "http://www.google.com")
  }

  public fun testIntentPart5() {
    val intent = Intent(Intent.ACTION_BATTERY_OKAY, Uri.parse("http://www.google.com"), getContext(), javaClass<Service>(), {
      putExtra("hoge", true)
    })
    assertTrue(intent.getBooleanExtra("hoge", false))
    assertEquals(intent.getData().toString(), "http://www.google.com")
    assertEquals(intent.getAction(), Intent.ACTION_BATTERY_OKAY)
  }

  public fun testToIntent1() {
    val intent = Intent.ACTION_BATTERY_OKAY.toIntent()
    assertEquals(intent.getAction(), Intent.ACTION_BATTERY_OKAY)
  }

  public fun testToIntent2() {
    val intent = Intent.ACTION_BATTERY_OKAY.toIntent { setData(Uri.parse("http://www.google.com"))}
    assertEquals(intent.getAction(), Intent.ACTION_BATTERY_OKAY)
    assertEquals(intent.getData().toString(), "http://www.google.com")
  }
}