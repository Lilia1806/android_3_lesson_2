package com.example.android_3_lesson_2.ui.fragments.locations

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_3_lesson_2.R
import com.example.android_3_lesson_2.base.BaseFragment
import com.example.android_3_lesson_2.databinding.FragmentLocationsBinding
import com.example.android_3_lesson_2.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationsFragment :
    BaseFragment<FragmentLocationsBinding, LocationViewModel>(R.layout.fragment_locations) {

    override val binding by viewBinding(FragmentLocationsBinding::bind)
    override val viewModel: LocationViewModel by activityViewModels()
    private var locationsAdapter = LocationAdapter(this::onItemClick)

    override fun initialize() {
        binding.rvLocations.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationsAdapter
        }
    }

    override fun setupObserves() {
        if (isOnline()) {
            viewModel.fetchLocation().observe(viewLifecycleOwner) {
                locationsAdapter.submitList(it.results)
                Toast.makeText(requireContext(), "online", Toast.LENGTH_SHORT).show()
            }
        } else {
            viewModel.getAll().observe(viewLifecycleOwner) {
                locationsAdapter.submitList(it)
                Toast.makeText(requireContext(), "offline", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun isOnline(): Boolean {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork ?: return false

        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            LocationsFragmentDirections.actionLocationsFragment2ToLocationDetailFragment(id)
        )
    }
}
