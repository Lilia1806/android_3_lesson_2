package com.example.android_3_lesson_2.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_3_lesson_2.databinding.ItemEpisodesBinding
import com.example.android_3_lesson_2.models.EpisodeModel

class EpisodesAdapter : RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {

    private var list: List<EpisodeModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<EpisodeModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(episodeModel: EpisodeModel) {
            binding.itemEpisodesCreated.text = episodeModel.created
            binding.itemEpisodesName.text = episodeModel.name
            binding.itemEpisodesAirDate.text = episodeModel.air_date
            binding.itemEpisodesAirUrl.text = episodeModel.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodesBinding.inflate(
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