package com.example.glidegiphy.data.remote.ResponseGif

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class GifDetailsData(
    val title: String,
    val import_datetime: String,
    val id: String
) : Parcelable