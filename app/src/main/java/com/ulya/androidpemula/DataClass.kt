package com.ulya.androidpemula

import android.os.Parcel
import android.os.Parcelable

data class DataClass(
    val imageResource: Int,
    val dataName: String,
    val dataDescription: String,
    val dataDetailDescription: String,
    val dataDetailImage: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResource)
        parcel.writeString(dataName)
        parcel.writeString(dataDescription)
        parcel.writeString(dataDetailDescription)
        parcel.writeInt(dataDetailImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataClass> {
        override fun createFromParcel(parcel: Parcel): DataClass {
            return DataClass(parcel)
        }

        override fun newArray(size: Int): Array<DataClass?> {
            return arrayOfNulls(size)
        }
    }
}
