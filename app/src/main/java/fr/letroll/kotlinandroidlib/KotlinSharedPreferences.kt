package fr.letroll.kotlinandroidlib

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

public fun SharedPreferences.edit(action : Editor.() -> Unit): Boolean {
  val e : Editor? = this.edit()
  if (e != null) {
    e.action()
    return e.commit()
  }
  return false
}