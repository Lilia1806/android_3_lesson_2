package com.example.android_3_lesson_2.ui.fragments.characters

import androidx.lifecycle.ViewModel
import com.example.android_3_lesson_2.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    fun fetchCharacter() = characterRepository.fetchCharacter()

    fun getAll() = characterRepository.getAll()
}