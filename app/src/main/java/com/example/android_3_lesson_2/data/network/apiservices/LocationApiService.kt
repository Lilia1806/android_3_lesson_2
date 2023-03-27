package com.example.android_3_lesson_2.data.network.apiservices

import com.example.android_3_lesson_2.models.LocationModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApiService {

    @GET("api/location")
    fun fetchLocation(): Call<RickAndMortyResponse<LocationModel>>

    @GET("/api/character/{id}")
    fun fetchLocationDetail(@Path("id") id: Int): retrofit2.Call<LocationModel>
}