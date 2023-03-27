package com.example.android_3_lesson_2.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "episodeModel")
data class EpisodeModel(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("air_date")
    val air_date: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String
)
