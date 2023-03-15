package com.example.android_3_lesson_2.ui.fragments.characters

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_3_lesson_2.App
import com.example.android_3_lesson_2.models.CharacterModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse

class CharacterViewModel : ViewModel() {

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        val data: MutableLiveData<RickAndMortyResponse<CharacterModel>> = MutableLiveData()
        App.characterApiService?.fetchCharacters()?.enqueue(object :
            retrofit2.Callback<RickAndMortyResponse<CharacterModel>> {
            override fun onResponse(
                call: retrofit2.Call<RickAndMortyResponse<CharacterModel>>,
                response: retrofit2.Response<RickAndMortyResponse<CharacterModel>>
            ) {
                data.value = response.body()
            }

            override fun onFailure(
                call: retrofit2.Call<RickAndMortyResponse<CharacterModel>>,
                t: Throwable
            ) {
                data.value = null
            }

        })
        return data
    }
}