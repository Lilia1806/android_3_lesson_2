package com.example.android_3_lesson_2.data.network.apiservices

import com.example.android_3_lesson_2.models.CharacterModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacter(): Call<RickAndMortyResponse<CharacterModel>>

    @GET("/api/character/{id}")
    fun fetchCharacterDetail(@Path("id") id: Int): Call<CharacterModel>
}
