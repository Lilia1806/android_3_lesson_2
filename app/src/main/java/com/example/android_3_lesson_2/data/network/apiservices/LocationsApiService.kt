package com.example.android_3_lesson_2.data.network.apiservices

import com.example.android_3_lesson_2.models.LocationModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.http.GET

interface LocationsApiService {

    @GET("api/location")
    fun fetchLocation(): retrofit2.Call<RickAndMortyResponse<LocationModel>>
}