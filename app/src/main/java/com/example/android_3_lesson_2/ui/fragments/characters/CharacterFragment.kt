package com.example.android_3_lesson_2.ui.fragments.characters

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_3_lesson_2.databinding.FragmentCharacterBinding
import com.example.android_3_lesson_2.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment() {

    private var viewModel : CharacterViewModel? = null
    private lateinit var binding : FragmentCharacterBinding
    private var characterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
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
            adapter = characterAdapter
        }
    }

    private fun setupObserve() {
        viewModel?.fetchCharacter()?.observe(viewLifecycleOwner) {
            characterAdapter.setList(it.results)
        }
    }
}