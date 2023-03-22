package com.example.android_3_lesson_2

import android.app.Application
import com.example.android_3_lesson_2.data.network.RetrofitClient
import com.example.android_3_lesson_2.data.network.apiservices.CharacterApiService
import com.example.android_3_lesson_2.data.network.apiservices.EpisodeApiService
import com.example.android_3_lesson_2.data.network.apiservices.LocationApiService

class App : Application() {

    companion object {
        val retrofitClient = RetrofitClient()
        var characterApiService: CharacterApiService? = null
        var episodesApiService: EpisodeApiService? = null
        var locationApiService: LocationApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApiService = retrofitClient.provideCharacterApiService()
        episodesApiService = retrofitClient.provideEpisodeApiService()
        locationApiService = retrofitClient.provideLocationApiService()
    }
}