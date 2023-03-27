package com.example.android_3_lesson_2.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characterModel")
data class CharacterModel(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("image")
    val image: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("origin")
    val origin: Any
)