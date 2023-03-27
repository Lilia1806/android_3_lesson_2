package com.example.android_3_lesson_2.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android_3_lesson_2.data.db.daos.CharacterDao
import com.example.android_3_lesson_2.data.network.apiservices.CharacterApiService
import com.example.android_3_lesson_2.models.CharacterModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.Call
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApiService: CharacterApiService,
    private val characterDao: CharacterDao
) {

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        val data: MutableLiveData<RickAndMortyResponse<CharacterModel>> = MutableLiveData()
        characterApiService.fetchCharacter()
            .enqueue(object : retrofit2.Callback<RickAndMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: retrofit2.Response<RickAndMortyResponse<CharacterModel>>
                ) {
                    if (response.body() != null) {
                        response.body().let {
                            it?.let { it1 -> characterDao.insertAll(it1.results) }
                        }
                    }
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun fetchCharacterDetail(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        characterApiService.fetchCharacterDetail(id)
            .enqueue(object : retrofit2.Callback<CharacterModel> {
                override fun onResponse(
                    call: Call<CharacterModel>,
                    response: retrofit2.Response<CharacterModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<CharacterModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun getAll(): LiveData<List<CharacterModel>> {
        return characterDao.getAll()
    }
}

//    fun fetchCharacter(): Flow<PagingData<CharacterModel>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                CharacterPagingSource(App.characterApiService!!)
//            }).flow
//    }