package com.vlad.android.kotlin

import org.json.JSONObject
import org.json.JSONArray

fun JSONArray.each(yield: (JSONObject) -> Unit) {
    (0..(this.length() - 1)).forEach { yield(this.getJSONObject(it)!!) }
}

