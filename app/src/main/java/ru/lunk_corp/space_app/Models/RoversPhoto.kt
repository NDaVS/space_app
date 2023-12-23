package ru.lunk_corp.space_app.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class RoversPhoto(
    val id: Int,
    val sol: Int,
    val camera: Cam,
    val img_src: String,
    val earth_date: String,
    val rover: Rover
) : Parcelable