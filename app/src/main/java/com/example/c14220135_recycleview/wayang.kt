package com.example.c14220135_recycleview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class wayang(
    var foto:String,
    var nama:String,
    var karakter: String,
    var deskripsi: String
): Parcelable


