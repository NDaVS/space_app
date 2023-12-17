package ru.lunk_corp.space_app.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.lunk_corp.space_app.Models.APOD_response
import ru.lunk_corp.space_app.Network.APODApiService
import ru.lunk_corp.space_app.Network.NASA_API

class mainViewModel(val context: Application) : AndroidViewModel(context) {
    private val apiService = NASA_API()

    private fun getAPOD(){
        var apod_data :APOD_response
        apiService.getAPOD(object : NASA_API.APODCallback{
            override fun onSuccess(response: APOD_response) {
                apod_data = response
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