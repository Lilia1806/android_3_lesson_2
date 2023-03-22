package com.example.android_3_lesson_2.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(uri: String) {
    Glide
        .with(this)
        .load(uri)
        .into(this)
}
