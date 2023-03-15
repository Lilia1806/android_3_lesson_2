package com.example.android_3_lesson_2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_3_lesson_2.databinding.ItemCharacterBinding
import com.example.android_3_lesson_2.models.CharacterModel

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private var list: List<CharacterModel> = ArrayList()

    fun setList(list: List<CharacterModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(characterModel: CharacterModel) {
            Glide.with(binding.itemCharacterImage.context).load(characterModel.image).into(binding.itemCharacterImage)
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

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}