package fr.letroll.kotlinandroidlib

import android.content.Intent
import android.net.Uri
import android.content.Context

public fun Intent(body: Intent.() -> Unit): Intent {
    val intent = Intent()
    intent.body()
    return intent
}

public fun Intent(o: Intent?, body: Intent.() -> Unit): Intent {
    val intent = Intent(o)
    intent.body()
    return intent
}

public fun Intent(action: String?, body: Intent.() -> Unit): Intent {
    val intent = Intent(action)
    intent.body()
    return intent
}

public fun String.toIntent(body: Intent.() -> Unit): Intent = Intent(this, body)

public fun String.toIntent(): Intent = Intent(this)

public fun Intent(action: String?, uri: Uri?, body: Intent.() -> Unit): Intent {
    val intent = Intent(action, uri)
    intent.body()
    return intent
}

public fun Intent(packageContext: Context?, cls: Class<*>?, body: Intent.() -> Unit): Intent {
    val intent = Intent(packageContext, cls)
    intent.body()
    return intent
}

public fun Intent(action: String?, uri: Uri?, packageContext: Context?, cls: Class<*>?, body: Intent.() -> Unit): Intent {
    val intent = Intent(action, uri, packageContext, cls)
    intent.body()
    return intent
}
