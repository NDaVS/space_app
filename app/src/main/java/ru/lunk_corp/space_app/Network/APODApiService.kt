package ru.lunk_corp.space_app.Network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.lunk_corp.space_app.Models.APOD_response

interface APODApiService {
    @GET("planetary/apod")
    fun getAPOD(@Query("api_key")key: String): Call<APOD_response>
}