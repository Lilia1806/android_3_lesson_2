package com.example.android_3_lesson_2.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_3_lesson_2.models.CharacterModel

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characterModel")
    fun getAll(): LiveData<List<CharacterModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(characterModel: List<CharacterModel>)
}