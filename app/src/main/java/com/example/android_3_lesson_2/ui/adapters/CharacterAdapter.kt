package com.example.android_3_lesson_2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_3_lesson_2.databinding.ItemCharacterBinding
import com.example.android_3_lesson_2.extension.setImage
import com.example.android_3_lesson_2.models.CharacterModel

class CharacterAdapter(
    val onItemClick: (id: Int) -> Unit
) : ListAdapter<CharacterModel, CharacterAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { character -> onItemClick(character.id) }
            }
        }

        fun onBind(characterModel: CharacterModel) {
            binding.itemCharacterImage.setImage(characterModel.image)
            binding.itemCharacterName.text = characterModel.name
            binding.itemCharacterStatus.text = characterModel.status
            binding.itemCharacterSpecies.text = characterModel.species
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
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
        private val diffUtil = object : DiffUtil.ItemCallback<CharacterModel>() {
            override fun areItemsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel,
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}