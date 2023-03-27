package com.example.android_3_lesson_2.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android_3_lesson_2.data.db.daos.LocationDao
import com.example.android_3_lesson_2.data.network.apiservices.LocationApiService
import com.example.android_3_lesson_2.models.LocationModel
import com.example.android_3_lesson_2.models.RickAndMortyResponse
import retrofit2.Call
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApiService: LocationApiService,
    private val locationDao: LocationDao
) {

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()
        locationApiService.fetchLocation()
            .enqueue(object : retrofit2.Callback<RickAndMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: retrofit2.Response<RickAndMortyResponse<LocationModel>>
                ) {
                    if (response.body() != null) {
                        response.body().let {
                            it?.let { it1 -> locationDao.insertAll(it1.results) }
                        }
                    }
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun fetchLocationDetail(id: Int): MutableLiveData<LocationModel> {
        val data: MutableLiveData<LocationModel> = MutableLiveData()
        locationApiService.fetchLocationDetail(id)
            .enqueue(object : retrofit2.Callback<LocationModel> {
                override fun onResponse(
                    call: Call<LocationModel>,
                    response: retrofit2.Response<LocationModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<LocationModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun getAll(): LiveData<List<LocationModel>> {
        return locationDao.getAll()
    }
}

//    fun fetchLocation(): Flow<PagingData<LocationModel>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                LocationPagingSource(App.locationApiService!!)
//            }).flow
//    }
