package ru.lunk_corp.space_app.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.lunk_corp.space_app.Models.astro_responce

class Open_notify_API() {
    private val url: String = "http://api.open-notify.org/"
    private val interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val api = retrofit.create(OpenNotifyService::class.java)

    fun getOpenNotifyApi(): OpenNotifyService {
        return this.api
    }

    interface OpenNotifyCallback {
        fun onSuccess(response: astro_responce)
        fun onError()
        fun onFailure(error: Throwable)
    }

    fun getResponce(callback: OpenNotifyCallback) {
        api.getAstronauts()
            .enqueue(object : retrofit2.Callback<astro_responce> {
                override fun onResponse(
                    call: retrofit2.Call<astro_responce>,
                    response: retrofit2.Response<astro_responce>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: retrofit2.Call<astro_responce>, t: Throwable) {
                    callback.onFailure(t)
                }
            })
    }

}