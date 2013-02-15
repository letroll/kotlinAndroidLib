package com.vlad.android.kotlintest

import junit.framework.TestCase
import com.vlad.android.kotlin.IntentFilter
import android.content.Intent
import kotlin.test.assertEquals

public class KotlinIntentFilterTest() : TestCase() {
  public fun testIntentFilter() {
    val filter = IntentFilter { addAction(Intent.ACTION_BATTERY_OKAY) }
    assertEquals(filter.getAction(0), Intent.ACTION_BATTERY_OKAY)
  }
}
