package com.vlad.android.kotlin

import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView.OnItemLongClickListener

public inline fun OnItemClickListener(action: (AdapterView<out Adapter>, View, Int, Long) -> Unit): OnItemClickListener {
    return object : OnItemClickListener {
        override fun onItemClick(parent: AdapterView<out Adapter?>?, view: View?, position: Int, id: Long) {
            action(parent as AdapterView<out Adapter>, view!!, position, id)
        }
    }
}

public inline fun OnItemLongClickListener(action: (AdapterView<out Adapter?>?, View?, Int, Long) -> Boolean): OnItemLongClickListener? {
    return object : OnItemLongClickListener {
        public override fun onItemLongClick(p0: AdapterView<out Adapter?>?, p1: View?, p2: Int, p3: Long): Boolean = action(p0, p1, p2, p3)
    }
}

public inline fun AdapterView<out Adapter?>.setOnItemClickListener(action: (AdapterView<out Adapter?>?, View?, Int, Long) -> Unit): Unit {
    setOnItemClickListener(OnItemClickListener(action))
}

public inline fun AdapterView<out Adapter?>.setOnItemLongClickListener(action: (AdapterView<out Adapter?>?, View?, Int, Long) -> Boolean): Unit {
    setOnItemLongClickListener(OnItemLongClickListener(action))
}
