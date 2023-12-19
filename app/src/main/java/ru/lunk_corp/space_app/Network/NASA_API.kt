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
    private val url:String  = "https://api.nasa.gov/"
    private val interceptor = HttpLoggingInterceptor()
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val api = retrofit.create(APODApiService::class.java)

    fun getApodApi(): APODApiService{
        return this.api
    }
    interface APODCallback{
        fun onSuccess(response: APOD_response)
        fun onError()
        fun onFailure(error:Throwable)
    }

    fun getAPOD(callback: APODCallback){
        api.getAPOD("THcIfmHCbVa60dyWgISdYogXuTTbm9ZpoI9yv7xe")
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

//    fun getMarsPhoto()
}