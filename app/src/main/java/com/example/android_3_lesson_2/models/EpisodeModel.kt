package com.example.android_3_lesson_2.models

import com.google.gson.annotations.SerializedName

data class EpisodeModel(

    @SerializedName("id")
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
