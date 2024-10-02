package com.example.playernitrixtest.data.network.api

import com.example.playernitrixtest.data.network.model.ApiVideoResponse
import com.example.playernitrixtest.utils.Constants.PAGE
import com.example.playernitrixtest.utils.Constants.PER_PAGE
import com.example.playernitrixtest.utils.Constants.VIDEO_LIST_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoApi {
    @GET(VIDEO_LIST_ENDPOINT)
    suspend fun getPopularVideo(
        @Query(PAGE) page: Int? = null,
        @Query(PER_PAGE) count: Int? = null
    ): ApiVideoResponse
}