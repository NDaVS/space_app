package ru.lunk_corp.space_app.ViewModels

import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.lunk_corp.space_app.APOD
import ru.lunk_corp.space_app.Models.APOD_Data
import ru.lunk_corp.space_app.Models.APOD_response
import ru.lunk_corp.space_app.Models.Photos
import ru.lunk_corp.space_app.Models.RoversPhoto
import ru.lunk_corp.space_app.Models.astro_responce
import ru.lunk_corp.space_app.Network.NASA_API
import ru.lunk_corp.space_app.Network.Open_notify_API

class MainViewModel(private val context: Application) : AndroidViewModel(context) {
    private val apiService = NASA_API()
    private val astroService = Open_notify_API()
    val apod_Data:  MutableLiveData<APOD_Data> = MutableLiveData()
    val mars_data: MutableLiveData<RoversPhoto> = MutableLiveData()
    val astro_data: MutableLiveData<astro_responce> = MutableLiveData()
    fun getAPOD(){

        apiService.getAPOD(object : NASA_API.APODCallback{
            override fun onSuccess(response: APOD_response) {
                apod_Data.value = APOD_Data(response.url, response.explanation)
            }

            override fun onError() {
                Log.ERROR
            }

            override fun onFailure(error: Throwable) {
                Log.ERROR
            }
        })

    }
    fun getMarsPhoto(){
        apiService.getMarsPhoto(object: NASA_API.RoverPhotoCallBack{
            override fun onSuccess(response: Photos) {
                mars_data.value = response.photos[1]
            }

            override fun onError() {
                Log.ERROR
            }

            override fun onFailure(error: Throwable) {
                Log.ERROR
            }
        })
    }

    fun getAstro(){
        astroService.getResponce(object : Open_notify_API.OpenNotifyCallback{
            override fun onSuccess(response: astro_responce) {
                astro_data.value = response
            }

            override fun onError() {
                Log.ERROR
            }

            override fun onFailure(error: Throwable) {
                Log.ERROR
            }
        })
    }

}