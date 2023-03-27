package com.example.android_3_lesson_2

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {

    @TypeConverter
    fun fromAnyToString(value: Any?):String?{
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromStringToAny(value: String?):Any?{
        if(value == null){
            return null
        }
        val type: Type = object :
            TypeToken<Any?>() {

        }.type
        return Gson().fromJson(value, type)
    }
}