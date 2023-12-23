package ru.lunk_corp.space_app.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Cam(
    val id: Int,
    val name: String,
    val rover_id: Int,
    val full_name: String
) : Parcelable