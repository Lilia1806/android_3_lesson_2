package com.example.android_3_lesson_2.data.network.apiservices

import com.example.android_3_lesson_2.models.EpisodeModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisode(): Call<RickAndMortyResponse<EpisodeModel>>

    @GET("/api/episode/{id}")
    fun fetchEpisodeDetail(@Path("id") id: Int): retrofit2.Call<EpisodeModel>
}