package ru.lunk_corp.space_app.Network

import retrofit2.Call
import retrofit2.http.GET
import ru.lunk_corp.space_app.Models.astro_responce

interface OpenNotifyService {

    @GET("astros")
    fun getAstronauts(): Call<astro_responce>
}