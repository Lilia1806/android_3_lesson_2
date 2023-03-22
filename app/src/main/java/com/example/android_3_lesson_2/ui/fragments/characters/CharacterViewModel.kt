package com.example.android_3_lesson_2.ui.fragments.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.android_3_lesson_2.data.repositories.CharacterRepository
import com.example.android_3_lesson_2.models.CharacterModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchCharacter() = characterRepository.fetchCharacter().cachedIn(viewModelScope)

    fun fetchCharacterDetail(id: Int): MutableLiveData<CharacterModel> {
        return characterRepository.fetchCharacterDetail(id)
    }
}