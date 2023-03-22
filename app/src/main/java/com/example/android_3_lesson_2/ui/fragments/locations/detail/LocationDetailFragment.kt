package com.example.android_3_lesson_2.ui.fragments.locations.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_3_lesson_2.R
import com.example.android_3_lesson_2.base.BaseFragment
import com.example.android_3_lesson_2.databinding.FragmentLocationDetailBinding
import com.example.android_3_lesson_2.ui.fragments.locations.LocationViewModel

class LocationDetailFragment :
    BaseFragment<FragmentLocationDetailBinding, LocationViewModel>(R.layout.fragment_location_detail) {

    override val binding by viewBinding(FragmentLocationDetailBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val args: LocationDetailFragmentArgs by navArgs()

    override fun setupObserves() {
        viewModel.fetchLocationDetail(args.id).observe(viewLifecycleOwner) {
            binding.itemLocationDetailName.text = it.name
            binding.itemLocationDetailType.text = it.type
        }
    }
}