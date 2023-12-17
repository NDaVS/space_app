package ru.lunk_corp.space_app.Network
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.lunk_corp.space_app.Models.APOD_response


class NASA_API() {
    private val apod_url:String  = "https://api.nasa.gov/planetary/apod"
    private val photo_url:String  = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos"
    private val interceptor = HttpLoggingInterceptor()
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    private val retrofit_apod = Retrofit.Builder()
        .baseUrl(apod_url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    private val retrofit_photo = Retrofit.Builder()
        .baseUrl(photo_url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    private val apod_api: APODApiService = retrofit_apod.create(APODApiService::class.java)

    fun getApodApi(): APODApiService{
        return this.apod_api
    }
    interface APODCallback{
        fun onSuccess(response: APOD_response)
        fun onError()
        fun onFailure(error:Throwable)
    }

    fun getAPOD(callback: APODCallback){
        apod_api.getAPOD("THcIfmHCbVa60dyWgISdYogXuTTbm9ZpoI9yv7xe")
            .enqueue(object : Callback<APOD_response>{
                override fun onResponse(
                    call: Call<APOD_response>,
                    response: Response<APOD_response>
                ) {
                    if(response.isSuccessful){
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<APOD_response>, t: Throwable) {
                    callback.onFailure(t)
                }
            })
    }
}