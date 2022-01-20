package com.example.activityobject

import android.os.Parcel
import android.os.Parcelable

class TestClass() : Parcelable {

    var data1: Int = 0
    var data2: String? = ""

    constructor(parcel: Parcel) : this() {
        data1 = parcel.readInt()
        data2 = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(data1)
        parcel.writeString(data2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestClass> {
        override fun createFromParcel(parcel: Parcel): TestClass {
            return TestClass(parcel)
        }

        override fun newArray(size: Int): Array<TestClass?> {
            return arrayOfNulls(size)
        }
    }
}