package com.example.android_3_lesson_2.ui.fragments.episodes

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_3_lesson_2.R
import com.example.android_3_lesson_2.base.BaseFragment
import com.example.android_3_lesson_2.databinding.FragmentEpisodesBinding
import com.example.android_3_lesson_2.ui.adapters.EpisodeAdapter
import kotlinx.coroutines.launch

class EpisodeFragment :
    BaseFragment<FragmentEpisodesBinding, EpisodeViewModel>(R.layout.fragment_episodes) {

    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private var episodesAdapter = EpisodeAdapter(this::onItemClick)

    override fun initialize() {
        binding.rvEpisodes.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodesAdapter
        }
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchEpisode().collect {
                episodesAdapter.submitData(it)
            }
        }
    }


    private fun onItemClick(id: Int) {
        findNavController().navigate(
            EpisodeFragmentDirections.actionEpisodesFragment2ToEpisodeDetailFragment(id)
        )
    }
}