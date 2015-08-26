package fr.letroll.kotlinandroidlib

import android.widget.Toast
import android.content.Context

public interface KotlinToastInterface : Context {
  fun shortToast(resId : Int)  = Toast.makeText(this, resId, Toast.LENGTH_SHORT)!!.show()
  fun shortToast(str : String) = Toast.makeText(this, str, Toast.LENGTH_SHORT)!!.show()
  fun longToast(resId : Int)   = Toast.makeText(this, resId, Toast.LENGTH_LONG)!!.show()
  fun longToast(str : String)  = Toast.makeText(this, str, Toast.LENGTH_LONG)!!.show()
}