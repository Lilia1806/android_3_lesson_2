package com.example.android_3_lesson_2.data.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android_3_lesson_2.App
import com.example.android_3_lesson_2.data.repositories.pagingsources.EpisodePagingSource
import com.example.android_3_lesson_2.models.EpisodeModel
import kotlinx.coroutines.flow.Flow

class EpisodeRepository {

    fun fetchEpisode(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EpisodePagingSource(App.episodesApiService!!)
            }).flow
    }

    fun fetchEpisodeDetail(id: Int): MutableLiveData<EpisodeModel> {
        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
        App.episodesApiService?.fetchEpisodeDetail(id)
            ?.enqueue(object : retrofit2.Callback<EpisodeModel> {
                override fun onResponse(
                    call: retrofit2.Call<EpisodeModel>,
                    response: retrofit2.Response<EpisodeModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: retrofit2.Call<EpisodeModel>,
                    t: Throwable
                ) {
                    data.value = null
                }

            })
        return data
    }
}