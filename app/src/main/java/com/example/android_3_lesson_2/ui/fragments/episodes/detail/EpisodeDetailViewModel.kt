package com.example.android_3_lesson_2.ui.fragments.episodes.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_3_lesson_2.data.repositories.EpisodeRepository
import com.example.android_3_lesson_2.models.EpisodeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    fun fetchEpisodeDetail(id: Int): MutableLiveData<EpisodeModel> {
        return episodeRepository.fetchEpisodeDetail(id)
    }
}