package fr.letroll.kotlinandroidlib

import android.app.Dialog
import android.view.View
import android.content.DialogInterface.OnClickListener
import android.content.DialogInterface
import android.app.AlertDialog
import android.app.AlertDialog.Builder
import android.content.DialogInterface.OnCancelListener
import android.database.Cursor
import android.widget.ListAdapter

public fun dialogOnClickListener(action: (dialog: DialogInterface?, which: Int) -> Unit): OnClickListener {
    return object : OnClickListener {
        public override fun onClick(p0: DialogInterface?, p1: Int) = action(p0, p1)
    }
}
public fun dialogOnCancelListener(action: (dialog: DialogInterface?) -> Unit): OnCancelListener {
  return object : OnCancelListener {
    public override fun onCancel(p0: DialogInterface?) = action(p0)
  }
}

public fun Builder.setPositiveButton(textId: Int, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setPositiveButton(textId, dialogOnClickListener(action))

public fun Builder.setPositiveButton(text: CharSequence, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setPositiveButton(text, dialogOnClickListener(action))

public fun Builder.setNeutralButton(textId: Int, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setNeutralButton(textId, dialogOnClickListener(action))

public fun Builder.setNeutralButton(text: CharSequence, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setNeutralButton(text, dialogOnClickListener(action))

public fun Builder.setNegativeButton(textId: Int, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setNegativeButton(textId, dialogOnClickListener(action))

public fun Builder.setNegativeButton(text: CharSequence, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setNegativeButton(text, dialogOnClickListener(action))

public fun Builder.setOnCancelListener(action: (dialog: DialogInterface?) -> Unit): Builder? =
    setOnCancelListener(dialogOnCancelListener(action))

public fun Builder.setCursor(cursor: Cursor?, labelColumn: String?, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setCursor(cursor, dialogOnClickListener(action), labelColumn)

public fun Builder.setSingleChoiceItems(itemsId: Int, checkedItem: Int, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setSingleChoiceItems(itemsId, checkedItem, dialogOnClickListener(action))

public fun Builder.setSingleChoiceItems(cursor: Cursor, checkedItem: Int, labelColumn: String, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setSingleChoiceItems(cursor, checkedItem, labelColumn, dialogOnClickListener(action))

public fun Builder.setSingleChoiceItems(adapter: ListAdapter, checkedItem: Int, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setSingleChoiceItems(adapter, checkedItem, dialogOnClickListener(action))

