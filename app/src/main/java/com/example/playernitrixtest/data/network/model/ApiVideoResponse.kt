package com.example.playernitrixtest.data.network.model

import com.squareup.moshi.Json

data class ApiVideoResponse(
    val page: Int?,
    @Json(name = "per_page") val perPage: Int?,
    val videos: List<VideoDto>?,
    @Json(name = "total_results") val totalResults: Int?,
    @Json(name = "next_page") val nextPage: String?,
    val url: String?
)