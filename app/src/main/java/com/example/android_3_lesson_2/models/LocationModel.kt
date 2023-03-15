package com.example.android_3_lesson_2.models

import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("url")
    val url: String,
)