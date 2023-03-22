package com.example.android_3_lesson_2.ui.fragments.locations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.android_3_lesson_2.data.repositories.LocationRepository
import com.example.android_3_lesson_2.models.LocationModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    fun fetchLocation() = locationRepository.fetchLocation().cachedIn(viewModelScope)

    fun fetchLocationDetail(id: Int): MutableLiveData<LocationModel> {
        return locationRepository.fetchLocationDetail(id)
    }
}