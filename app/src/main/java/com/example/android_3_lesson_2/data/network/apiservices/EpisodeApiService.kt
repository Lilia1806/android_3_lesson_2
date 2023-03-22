package com.example.android_3_lesson_2.data.network.apiservices

import com.example.android_3_lesson_2.models.EpisodeModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun fetchEpisode(@Query("page") page: Int): RickAndMortyResponse<EpisodeModel>

    @GET("/api/episode/{id}")
    fun fetchEpisodeDetail(@Path("id") id: Int): retrofit2.Call<EpisodeModel>
}