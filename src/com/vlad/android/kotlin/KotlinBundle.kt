package com.vlad.android.kotlin

import android.os.Bundle

public inline fun Bundle(body: Bundle.() -> Unit): Bundle {
    val bundle = Bundle()
    bundle.body()
    return bundle
}

public inline fun Bundle(loader: ClassLoader, body: Bundle.() -> Unit): Bundle {
    val bundle = Bundle(loader)
    bundle.body()
    return bundle
}

public inline fun Bundle(capacity: Int, body: Bundle.() -> Unit): Bundle {
    val bundle = Bundle(capacity)
    bundle.body()
    return bundle
}

public inline fun Bundle(b: Bundle?, body: Bundle.() -> Unit): Bundle {
    val bundle = if(b != null) Bundle(b) else Bundle()
    bundle.body()
    return bundle
}
