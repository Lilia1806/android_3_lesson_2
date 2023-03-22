package com.example.android_3_lesson_2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_3_lesson_2.databinding.ItemEpisodesBinding
import com.example.android_3_lesson_2.models.EpisodeModel

class EpisodeAdapter(
    val onItemClick: (Id: Int) -> Unit
) : PagingDataAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { character -> onItemClick(character.id) }
            }
        }

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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<EpisodeModel>() {
            override fun areItemsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel,
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}