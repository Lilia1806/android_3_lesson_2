package com.example.android_3_lesson_2.ui.fragments.episodes

import androidx.lifecycle.ViewModel
import com.example.android_3_lesson_2.data.repositories.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    fun fetchEpisode() = episodeRepository.fetchEpisode()

    fun getAll() = episodeRepository.getAll()
}