package com.example.android_3_lesson_2.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_3_lesson_2.databinding.ItemLocationsBinding
import com.example.android_3_lesson_2.models.LocationModel

class LocationsAdapter : RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {

    private var list: List<LocationModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<LocationModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemLocationsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(locationModel: LocationModel) {
            binding.itemLocationName.text = locationModel.name
            binding.itemLocationType.text = locationModel.type
            binding.itemLocationDimension.text = locationModel.dimension
            binding.itemLocationUrl.text = locationModel.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}