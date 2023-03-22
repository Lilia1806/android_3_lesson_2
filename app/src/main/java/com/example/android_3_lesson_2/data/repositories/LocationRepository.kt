package com.example.android_3_lesson_2.data.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android_3_lesson_2.App
import com.example.android_3_lesson_2.data.repositories.pagingsources.LocationPagingSource
import com.example.android_3_lesson_2.models.LocationModel
import kotlinx.coroutines.flow.Flow

class LocationRepository {

    fun fetchLocation(): Flow<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                LocationPagingSource(App.locationApiService!!)
            }).flow
    }

    fun fetchLocationDetail(id: Int): MutableLiveData<LocationModel> {
        val data: MutableLiveData<LocationModel> = MutableLiveData()
        App.locationApiService?.fetchLocationDetail(id)
            ?.enqueue(object : retrofit2.Callback<LocationModel> {
                override fun onResponse(
                    call: retrofit2.Call<LocationModel>,
                    response: retrofit2.Response<LocationModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: retrofit2.Call<LocationModel>,
                    t: Throwable
                ) {
                    data.value = null
                }

            })
        return data
    }
}