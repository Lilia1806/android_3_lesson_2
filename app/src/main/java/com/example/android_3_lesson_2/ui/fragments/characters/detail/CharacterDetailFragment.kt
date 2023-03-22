package com.example.android_3_lesson_2.ui.fragments.characters.detail

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_3_lesson_2.R
import com.example.android_3_lesson_2.base.BaseFragment
import com.example.android_3_lesson_2.databinding.FragmentCharacterDetailBinding
import com.example.android_3_lesson_2.extension.setImage
import com.example.android_3_lesson_2.ui.fragments.characters.CharacterViewModel

class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding, CharacterViewModel>(R.layout.fragment_character_detail) {

    override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    override val viewModel: CharacterViewModel by activityViewModels()
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun setupObserves() {
        viewModel.fetchCharacterDetail(args.id).observe(viewLifecycleOwner) {
            binding.itemCharacterDetailName.text = it.name
            binding.characterDetailImage.setImage(it.image)
        }
    }
}