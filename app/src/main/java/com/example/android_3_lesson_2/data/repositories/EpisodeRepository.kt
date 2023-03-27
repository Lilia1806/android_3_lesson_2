package com.example.android_3_lesson_2.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android_3_lesson_2.data.db.daos.EpisodeDao
import com.example.android_3_lesson_2.data.network.apiservices.EpisodeApiService
import com.example.android_3_lesson_2.models.EpisodeModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.Call
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val episodeApiService: EpisodeApiService,
    private val episodeDao: EpisodeDao
) {

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        val data: MutableLiveData<RickAndMortyResponse<EpisodeModel>> = MutableLiveData()
        episodeApiService.fetchEpisode()
            .enqueue(object : retrofit2.Callback<RickAndMortyResponse<EpisodeModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    response: retrofit2.Response<RickAndMortyResponse<EpisodeModel>>
                ) {
                    if (response.body() != null) {
                        response.body().let {
                            it?.let { it1 -> episodeDao.insertAll(it1.results) }
                        }
                    }
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun fetchEpisodeDetail(id: Int): MutableLiveData<EpisodeModel> {
        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
        episodeApiService.fetchEpisodeDetail(id)
            .enqueue(object : retrofit2.Callback<EpisodeModel> {
                override fun onResponse(
                    call: Call<EpisodeModel>,
                    response: retrofit2.Response<EpisodeModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<EpisodeModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun getAll(): LiveData<List<EpisodeModel>> {
        return episodeDao.getAll()
    }
}

//    fun fetchEpisode(): Flow<PagingData<EpisodeModel>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                EpisodePagingSource(App.episodesApiService!!)
//            }).flow
//    }
