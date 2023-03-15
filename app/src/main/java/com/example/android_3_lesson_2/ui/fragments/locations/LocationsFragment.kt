package com.example.android_3_lesson_2.ui.fragments.locations

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_3_lesson_2.databinding.FragmentLocationsBinding
import com.example.android_3_lesson_2.ui.adapters.LocationsAdapter

class LocationsFragment : Fragment() {

    private var viewModel: LocationsViewModel? = null
    private lateinit var binding: FragmentLocationsBinding
    private var locationsAdapter = LocationsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LocationsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.rvLocations.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationsAdapter
        }
    }

    private fun setupObserve() {
        viewModel?.fetchLocation()?.observe(viewLifecycleOwner) {
            locationsAdapter.setList(it.results)
        }
    }
}