package ru.lunk_corp.space_app.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Photos (
    val photos: List<RoversPhoto>
) : Parcelable