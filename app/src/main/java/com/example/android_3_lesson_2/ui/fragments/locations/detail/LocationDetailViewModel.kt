package com.example.android_3_lesson_2.ui.fragments.locations.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_3_lesson_2.data.repositories.LocationRepository
import com.example.android_3_lesson_2.models.LocationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun fetchLocationDetail(id: Int): MutableLiveData<LocationModel> {
        return locationRepository.fetchLocationDetail(id)
    }

}