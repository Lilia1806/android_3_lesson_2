package com.example.android_3_lesson_2.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_3_lesson_2.models.LocationModel

@Dao
interface LocationDao {

    @Query("SELECT * FROM locationModel")
    fun getAll(): LiveData<List<LocationModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(locationModel: List<LocationModel>)
}