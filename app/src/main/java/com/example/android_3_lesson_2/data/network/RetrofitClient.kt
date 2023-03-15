package com.example.android_3_lesson_2.data.network

import com.example.android_3_lesson_2.data.network.apiservices.CharacterApiService
import com.example.android_3_lesson_2.data.network.apiservices.EpisodesApiService
import com.example.android_3_lesson_2.data.network.apiservices.LocationsApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideCharacterApiService(): CharacterApiService {
        return retrofitClient.create(CharacterApiService::class.java)
    }

    fun provideLocationApiService(): LocationsApiService {
        return retrofitClient.create(LocationsApiService::class.java)
    }

    fun provideEpisodeApiService(): EpisodesApiService {
        return retrofitClient.create(EpisodesApiService::class.java)
    }
}