package com.example.android_3_lesson_2.ui.fragments.episodes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_3_lesson_2.App
import com.example.android_3_lesson_2.models.EpisodeModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse

class EpisodesViewModel : ViewModel() {

    fun fetchEpisodes(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        val data: MutableLiveData<RickAndMortyResponse<EpisodeModel>> = MutableLiveData()
        App.episodesApiService?.fetchEpisodes()?.enqueue(object :
            retrofit2.Callback<RickAndMortyResponse<EpisodeModel>> {
            override fun onResponse(
                call: retrofit2.Call<RickAndMortyResponse<EpisodeModel>>,
                response: retrofit2.Response<RickAndMortyResponse<EpisodeModel>>
            ) {
                data.value = response.body()
            }

            override fun onFailure(
                call: retrofit2.Call<RickAndMortyResponse<EpisodeModel>>,
                t: Throwable
            ) {
                data.value = null
            }

        })
        return data
    }
}