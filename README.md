Kotlin for Android
=============

Helps not to write boilerplate code with instantiating abstract or interfaces instances.
The purpose of the library is to save time of writing code using Android SDK wrapping as much as possible
common functionality.


Warning
-------

This project is not relative to JetBrains company or their products. Use this project as is, no author nor anybody else
is responsible for any damage.

Linking to Android project
--------------------------

1. Create regular or use existing Android project in IDEA
2. Clone this project in the parent folder of your project
3. Write in the file setting.gradle:

```
include ':kotlinandroidlib'
project(':kotlinandroidlib').projectDir=new File('../kotlinAndroidLib/app')
```

4. Write in the module build.gradle in Android dependencies:

```
compile project(':kotlinandroidlib')
```

5. do a gradle Sync and voila!

Usage
-----

Small example of usage most of the functions and also some examples like how to create Parcelable.
See [Sample Activity](https://github.com/letroll/kotlinAndroidLib/blob/master/SampleActivity.kt)

* `findViewById` replacement for Activity and View:

        val myButton = findView<Button>(R.id.my_button)

* `setOnClickListener` for Views:

        myView?.setOnClickListener { /* code here */ }
        myView?.setOnClickListener { view -> /* code here with view: View? argument */ }
        val onClickListener = OnClickListener { view -> /* code here */ }

        myView?.setOnTouchListener { view, event -> false /* with view: View? and event: MotionEvent? */ }
        val onTouchListener = OnTouchListener { view, event -> false }

* `runOnUiThread` for Activities:

    It can be used without the library:

        runOnUiThread(runnable { /* action */})

    Library just remove runnable call and can be used as:

        runOnUiThread { /* action */ }

* Short definition of `BroadcastReceiver`:

    Library just wraps `onReceive` call:

        val myBroadcastReceiver = BroadcastReceiver { context, intent ->
            /* handle intent here */
        }

* `setPositiveButton` and `setNegativeButton` for AlertDialog.Builder:

        AlertDialog.Builder(this).setTitle("Hello")
            ?.setMessage("Want to say hello to world?")
            ?.setPositiveButton("Yes", { dialog, which -> /* hello */ })
            ?.setNegativeButton("No", { dialog, which -> /* no hello now */ })
            ?.create()

        val positiveButton = dialogOnClickListener { dialog, which -> }

* Short definition of `OnEditorActionListener`:

    Library just wraps `onEditorAction` call:

        val myEditorActionListener = OnEditorActionListener { v, actionId, event ->
            /* handle actionId and/or event */
            false
        }

        myEditText?.setOnEditorActionListener /* OnEditorActionListener */ { v, actionId, event ->
            false
        }

* `getSystemService` with or without casting for known services:

    Library allows call with casting for specific name of the service or call directly for known services:

        val inputMethodManager = getSystemServiceAs<InputMethodManager>(Context.INPUT_METHOD_SERVICE)
        val inputMethodManager = getInputMethodService()

* `AdapterView<out Adapter?>.setOnItemClickListener` and `AdapterView<out Adapter?>.setOnItemLongClickListener`:

        listView.setOnItemClickListener { parent, view, position, id -> }
        listView.setOnItemLongClickListener { parent, view, position, id -> false }

* Wrap calls without runnable() for `Handler`:

        val handler = Handler()
        handler.post { /* code here */ }
        handler.postDelayed(100) { /* code here */ }
        handler.postAtFrontOfQueue { /* code here */ }
        handler.postAtTime(System.currentTimeMillis() + 100) { /* code here */ }

    Also easy to create handler with callback to handle messages:

        val handler = Handler { message ->
            when (message.what) {
                1 -> handleMessage1(message.getData())
                else -> false
            }
        }

* Wrap `SQLiteDatabase` functionality:

    * Wrap pattern: beginTransaction -> setTransactionSuccessful -> endTransaction with try and finally:

            sqliteDatabase.transaction {
                // call any method of SQLiteDatabase without . or ?.
                execSQL("ALTER TABLE table_1 RENAME TO table_2")
            }

    * Wrap pattern: cursor not null -> moveToFirst -> moveToNext in do-while loop -> close with try and finally:

            // query call with same arguments + last argument is a body in the loop
            val collection /* of String */ = sqliteDatabase.query<String>("people", array("first_name"), null, null, null, null, null, null) {
                /* Cursor namespace */
                getString(getColumnIndexOrThrow("first_name"))
            }

        Support also queryWithFactory, rawQuery and rawQueryWithFactory.

    * Wrap ContentValues for insert and update:

            sqliteDatabase?.insert("table_name", null) {
                // ContentValues namespace
                put("column_text", "Hello")
                put("column_int", 12.toInt())
                put("column_float", 13.toFloat())
            }

            sqliteDatabase?.update("table_name", "ID = ?", array("3")) {
                // ContentValues namespace
                put("column_text", "Hello World")
            }

* Wrap `Cursor` pattern moveToFirst -> moveToNext in do-while loop:

    Possible to call all functions on Cursor?, if Cursor? == null, returns empty collection

        try {
            val collection /* Of String? */ = cursor.map {
                getString(getColumnIndexOrThrow("first_name"))
            }
        } finally {
            cursor?.close()
        }

    or

        val collection = LinkedList<String?>()
        try {
            cursor.mapTo(collection) {
                getString(getColumnIndexOrThrow("first_name"))
            }
        } finally {
            cursor?.close()
        }

    or

        val collection /* Of String? */ = cursor.mapAndClose {
            getString(getColumnIndexOrThrow("first_name"))
        }

* `ExecutorService`:

        executorService.execute { /* code here */ }
        val future = executorService.submit<Any?> { /* code here and no result */ }
        val future = executorService.submit<String?> { /* code here */ "Result" }
        val future = executorService.submit<String?>("Result") { /* code here and result */ }

* Wrap `Intent`, now easy to create new `Intent` without defining new variable:

        sendBroadcast(Intent() { setAction(Intent.ACTION_DEFAULT) })
        startActivity(Intent(Intent.ACTION_VIEW) { setDataAndType(Uri.parse("http://example.com/audio.mp3"), "audio/mpeg") })

    or make it even nicer if you have an action and it's a `String` value:

        "my.application.intent.action.ACTION_MINE" toIntent {
            /* namespace of Intent */
        }

    or just convert `String` to `Intent`:

        "my.application.intent.action.ACTION_MINE".toIntent()

* Wrap `IntentFilter`, now easy to create new `IntentFilter` without defining new variable:

        registerReceiver(broadcastReceiver, IntentFilter {
            addAction(ACTION_HELLO)
        })

* Wrap `Bundle`, now easy to create new `Bundle` without defining new variable:

        Bundle { putString("result", "Some result!") }

* Short definition of `ResultReceiver`:

    Library just wraps `onReceiveResult` call:

        val myResultReceiver = ResultReceiver(Hanlder()) { code, data ->
            /* handle result here */
        }

    or automatically create new `Hanlder`

        val myResultReceiver = ResultReceiver { code, data ->
            /* handle result here */
        }

* Wrap 'CREATOR' for `Parcelable`. Example of usage:

    WARNING: It might wrong or not supported yet!

        class MyParcelable(val number: Int, val text: String?) : Parcelable {

            public override fun writeToParcel(p0: Parcel?, p1: Int) = if (p0 != null) {
                p0.writeInt(number)
                p0.writeString(text)
            }

            public override fun describeContents(): Int = 0

            class object {

                val CREATOR = CreateParcelable<MyParcelable> { MyParcelable(it.readInt(), it.readString()) }
            }
        }

* Wrap `Thread`, `run` and call `start` method:

        async {
            // some code here
        }

Credits
-------
[Vladimir Lichonos](https://github.com/vladlichonos)
[Julien Quiévreux](https://github.com/letroll)