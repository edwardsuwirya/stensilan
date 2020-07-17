package com.enigmacamp.stensilan.model

import android.os.Parcel
import android.os.Parcelable

data class Stensil(
    val title: String,
    val content: String,
    val author: String,
    val category: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(author)
        parcel.writeString(category)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Stensil> {
        override fun createFromParcel(parcel: Parcel): Stensil {
            return Stensil(parcel)
        }

        override fun newArray(size: Int): Array<Stensil?> {
            return arrayOfNulls(size)
        }
    }

}