package com.example.android_3_lesson_2.ui.fragments.locations

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_3_lesson_2.R
import com.example.android_3_lesson_2.base.BaseFragment
import com.example.android_3_lesson_2.databinding.FragmentLocationsBinding
import com.example.android_3_lesson_2.ui.adapters.LocationAdapter
import kotlinx.coroutines.launch

class LocationsFragment :
    BaseFragment<FragmentLocationsBinding, LocationViewModel>(R.layout.fragment_locations) {

    override val binding by viewBinding(FragmentLocationsBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private var locationsAdapter = LocationAdapter(this::onItemClick)

    override fun initialize() {
        binding.rvLocations.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationsAdapter
        }
    }

    override fun setupObserves() {
        lifecycleScope.launch() {
            viewModel.fetchLocation().collect {
                locationsAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            LocationsFragmentDirections.actionLocationsFragment2ToLocationDetailFragment(id)
        )
    }
}