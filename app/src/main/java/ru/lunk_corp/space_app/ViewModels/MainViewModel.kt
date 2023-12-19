package ru.lunk_corp.space_app.ViewModels

import android.app.Application
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.lunk_corp.space_app.APOD
import ru.lunk_corp.space_app.Models.APOD_Data
import ru.lunk_corp.space_app.Models.APOD_response
import ru.lunk_corp.space_app.Network.NASA_API

class MainViewModel(private val context: Application) : AndroidViewModel(context) {
    private val apiService = NASA_API()
    val apod_Data:  MutableLiveData<APOD_Data> = MutableLiveData()
    fun getAPOD(){

        apiService.getAPOD(object : NASA_API.APODCallback{
            override fun onSuccess(response: APOD_response) {
                apod_Data.value = APOD_Data(response.url, response.explanation)
            }

            override fun onError() {
                TODO("Not yet implemented")
            }

            override fun onFailure(error: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

}