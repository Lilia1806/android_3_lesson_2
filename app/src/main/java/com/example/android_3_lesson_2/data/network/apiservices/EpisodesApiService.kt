package com.example.android_3_lesson_2.data.network.apiservices

import com.example.android_3_lesson_2.models.EpisodeModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.http.GET

interface EpisodesApiService {

    @GET("api/episode")
    fun fetchEpisodes(): retrofit2.Call<RickAndMortyResponse<EpisodeModel>>
}