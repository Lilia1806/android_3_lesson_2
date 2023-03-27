package com.example.android_3_lesson_2.ui.fragments.episodes.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_3_lesson_2.R
import com.example.android_3_lesson_2.base.BaseFragment
import com.example.android_3_lesson_2.databinding.FragmentEpisodesDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailFragment :
    BaseFragment<FragmentEpisodesDetailBinding, EpisodeDetailViewModel>(R.layout.fragment_episodes_detail) {

    override val binding by viewBinding(FragmentEpisodesDetailBinding::bind)
    override val viewModel: EpisodeDetailViewModel by viewModels()
    private val args: EpisodeDetailFragmentArgs by navArgs()

    override fun setupObserves() {
        viewModel.fetchEpisodeDetail(args.id).observe(viewLifecycleOwner) {
            binding.itemEpisodesDetailName.text = it.name
            binding.itemEpisodesDetailAirDate.text = it.air_date
        }
    }
}