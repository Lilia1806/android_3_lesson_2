package com.example.android_3_lesson_2.data.network.apiservices

import com.example.android_3_lesson_2.models.LocationModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchLocation(@Query("page") page: Int): RickAndMortyResponse<LocationModel>

    @GET("/api/character/{id}")
    fun fetchLocationDetail(@Path("id") id: Int): retrofit2.Call<LocationModel>
}