package com.example.android_3_lesson_2.ui.fragments.episodes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_3_lesson_2.databinding.FragmentEpisodesBinding
import com.example.android_3_lesson_2.ui.adapters.EpisodesAdapter

class EpisodesFragment : Fragment() {

    private var viewModel: EpisodesViewModel? = null
    private lateinit var binding: FragmentEpisodesBinding
    private var episodesAdapter = EpisodesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[EpisodesViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.rvCharacter.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodesAdapter
        }
    }

    private fun setupObserve() {
        viewModel?.fetchEpisodes()?.observe(viewLifecycleOwner) {
            episodesAdapter.setList(it.results)
        }
    }
}