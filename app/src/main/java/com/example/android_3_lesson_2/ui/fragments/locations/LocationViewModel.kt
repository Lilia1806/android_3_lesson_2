package com.example.android_3_lesson_2.ui.fragments.locations

import androidx.lifecycle.ViewModel
import com.example.android_3_lesson_2.data.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun fetchLocation() = locationRepository.fetchLocation()

    fun getAll() = locationRepository.getAll()
}