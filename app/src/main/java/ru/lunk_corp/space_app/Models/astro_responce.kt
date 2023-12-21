package ru.lunk_corp.space_app.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class astro_responce (
    val message: String,
    val number: Int,
    val people: List<People>
) : Parcelable