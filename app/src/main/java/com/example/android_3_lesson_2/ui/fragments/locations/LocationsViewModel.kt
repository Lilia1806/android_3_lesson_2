package com.example.android_3_lesson_2.ui.fragments.locations

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_3_lesson_2.App
import com.example.android_3_lesson_2.models.LocationModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse

class LocationsViewModel : ViewModel() {

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()
        App.locationApiService?.fetchLocation()?.enqueue(object :
            retrofit2.Callback<RickAndMortyResponse<LocationModel>> {
            override fun onResponse(
                call: retrofit2.Call<RickAndMortyResponse<LocationModel>>,
                response: retrofit2.Response<RickAndMortyResponse<LocationModel>>
            ) {
                data.value = response.body()
            }

            override fun onFailure(
                call: retrofit2.Call<RickAndMortyResponse<LocationModel>>,
                t: Throwable
            ) {
                data.value = null
            }

        })
        return data
    }
}