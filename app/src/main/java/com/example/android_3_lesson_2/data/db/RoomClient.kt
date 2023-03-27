package com.example.android_3_lesson_2.data.db

import android.content.Context
import androidx.room.Room
import com.example.android_3_lesson_2.data.db.daos.CharacterDao
import com.example.android_3_lesson_2.data.db.daos.EpisodeDao
import com.example.android_3_lesson_2.data.db.daos.LocationDao

class RoomClient {

    fun provideRoom(context: Context) = Room
        .databaseBuilder(context, AppDatabase::class.java, "room")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()

    fun provideCharacterDao(appDatabase: AppDatabase): CharacterDao = appDatabase.characterDao()

    fun provideEpisodeDao(appDatabase: AppDatabase): EpisodeDao = appDatabase.episodeDao()

    fun provideLocationDao(appDatabase: AppDatabase): LocationDao = appDatabase.locationDao()
}