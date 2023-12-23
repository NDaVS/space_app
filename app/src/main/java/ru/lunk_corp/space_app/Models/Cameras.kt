package ru.lunk_corp.space_app.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Cameras(
    val name: String,
    val full_name: String
) : Parcelable