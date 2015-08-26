package fr.letroll.kotlinandroidlib

import android.os.Bundle

public fun Bundle(body: Bundle.() -> Unit): Bundle {
    val bundle = Bundle()
    bundle.body()
    return bundle
}

public fun Bundle(loader: ClassLoader, body: Bundle.() -> Unit): Bundle {
    val bundle = Bundle(loader)
    bundle.body()
    return bundle
}

public fun Bundle(capacity: Int, body: Bundle.() -> Unit): Bundle {
    val bundle = Bundle(capacity)
    bundle.body()
    return bundle
}

public fun Bundle(b: Bundle?, body: Bundle.() -> Unit): Bundle {
    val bundle = Bundle(b)
    bundle.body()
    return bundle
}
