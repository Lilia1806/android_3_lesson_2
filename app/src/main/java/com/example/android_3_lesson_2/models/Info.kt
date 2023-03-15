package com.example.android_3_lesson_2.models

import com.google.gson.annotations.SerializedName

class Info(

    @SerializedName("count")
    val count: Int,

    @SerializedName("pages")
    val pages: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("prev")
    val prev: String
)