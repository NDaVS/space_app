package ru.lunk_corp.space_app.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class APOD_Data(
    val url: String,
    val explanation: String
) : Parcelable