package com.example.android_3_lesson_2.data.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android_3_lesson_2.App
import com.example.android_3_lesson_2.data.repositories.pagingsources.CharacterPagingSource
import com.example.android_3_lesson_2.models.CharacterModel
import kotlinx.coroutines.flow.Flow

class CharacterRepository {

    fun fetchCharacter(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPagingSource(App.characterApiService!!)
            }).flow
    }

    fun fetchCharacterDetail(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        App.characterApiService?.fetchCharacterDetail(id)
            ?.enqueue(object : retrofit2.Callback<CharacterModel> {
                override fun onResponse(
                    call: retrofit2.Call<CharacterModel>,
                    response: retrofit2.Response<CharacterModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: retrofit2.Call<CharacterModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}