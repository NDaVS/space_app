package ru.lunk_corp.space_app.Network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.lunk_corp.space_app.Models.APOD_response
import ru.lunk_corp.space_app.Models.Photos

interface NASAApiService {
    @GET("planetary/apod")
    fun getAPOD(@Query("api_key") key: String): Call<APOD_response>

    @GET("/mars-photos/api/v1/rovers/curiosity/photos")
    fun getMarsPhoto(
        @Query("api_key") key: String,
        @Query("sol") sol: Int,
        @Query("page") page: Int
    ): Call<Photos>
}