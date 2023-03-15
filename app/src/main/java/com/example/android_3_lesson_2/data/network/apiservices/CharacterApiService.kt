package com.example.android_3_lesson_2.data.network.apiservices

import com.example.android_3_lesson_2.models.CharacterModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(): retrofit2.Call<RickAndMortyResponse<CharacterModel>>
}