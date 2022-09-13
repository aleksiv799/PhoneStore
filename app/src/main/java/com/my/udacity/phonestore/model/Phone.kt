package com.my.udacity.phonestore.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Phone(
    var name: String,
    var systemOS: String,
    var company: String,
    var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable