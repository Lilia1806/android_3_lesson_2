package com.example.android_3_lesson_2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android_3_lesson_2.data.db.daos.CharacterDao
import com.example.android_3_lesson_2.data.db.daos.EpisodeDao
import com.example.android_3_lesson_2.data.db.daos.LocationDao
import com.example.android_3_lesson_2.models.CharacterModel
import com.example.android_3_lesson_2.models.EpisodeModel
import com.example.android_3_lesson_2.models.LocationModel
import com.example.android_3_lesson_2.utils.CharacterConverter

@Database(entities = [CharacterModel::class, EpisodeModel::class, LocationModel::class], version = 3)
@TypeConverters(CharacterConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    abstract fun episodeDao(): EpisodeDao

    abstract fun locationDao(): LocationDao
}