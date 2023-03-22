package com.example.android_3_lesson_2.data.network.apiservices

import com.example.android_3_lesson_2.models.CharacterModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacter(@Query("page") page: Int): RickAndMortyResponse<CharacterModel>

    @GET("/api/character/{id}")
    fun fetchCharacterDetail(@Path("id") id: Int): retrofit2.Call<CharacterModel>
}
