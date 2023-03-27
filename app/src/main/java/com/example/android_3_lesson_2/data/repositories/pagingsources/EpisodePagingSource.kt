package com.example.android_3_lesson_2.data.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android_3_lesson_2.data.network.apiservices.EpisodeApiService
import com.example.android_3_lesson_2.models.EpisodeModel
import retrofit2.HttpException
import java.io.IOException
//
//private const val LOCATION_STARTING_PAGE_INDEX = 1
//
//class EpisodePagingSource(private val service: EpisodeApiService) :
//    PagingSource<Int, EpisodeModel>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeModel> {
//        val position = params.key ?: LOCATION_STARTING_PAGE_INDEX
//        return try {
//            val response = service.fetchEpisode(position)
//            val nextPageNumber = Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
//            LoadResult.Page(
//                data = response.results,
//                prevKey = null,
//                nextKey = nextPageNumber
//            )
//        } catch (exception: IOException) {
//            return LoadResult.Error(exception)
//        } catch (exception: HttpException) {
//            return LoadResult.Error(exception)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, EpisodeModel>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//}