package fr.letroll.kotlinandroidlib

import android.os.Parcelable
import android.os.Parcel
import java.util.ArrayList

public fun CreateParcelable<T: Parcelable>(create: (Parcel) -> T?): Parcelable.Creator<T> {
    return object : Parcelable.Creator<T> {
        override fun createFromParcel(p0: Parcel?): T? = if (p0 != null) create(p0) else null
        override fun newArray(p0: Int): Array<out T>? = arrayOfNulls<Class<T>>(p0) as Array<T>?
    }
}
