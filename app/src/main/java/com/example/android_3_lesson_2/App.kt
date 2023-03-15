package com.example.android_3_lesson_2

import android.app.Application
import com.example.android_3_lesson_2.data.network.RetrofitClient
import com.example.android_3_lesson_2.data.network.apiservices.CharacterApiService
import com.example.android_3_lesson_2.data.network.apiservices.EpisodesApiService
import com.example.android_3_lesson_2.data.network.apiservices.LocationsApiService

class App : Application() {

    companion object {
        val retrofitClient = RetrofitClient()
        var characterApiService: CharacterApiService? = null
        var episodesApiService: EpisodesApiService? = null
        var locationApiService: LocationsApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApiService = retrofitClient.provideCharacterApiService()
        episodesApiService = retrofitClient.provideEpisodeApiService()
        locationApiService = retrofitClient.provideLocationApiService()
    }
}