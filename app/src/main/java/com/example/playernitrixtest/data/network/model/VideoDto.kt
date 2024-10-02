package com.example.playernitrixtest.data.network.model

import com.squareup.moshi.Json

data class VideoDto(
    val id: Int?,
    val width: Int?,
    val height: Int?,
    val duration: Int?,
    @Json(name = "full_res") val fullRes: String?,
    val tags: List<String>?,
    val url: String?,
    val image: String?,
    @Json(name = "avg_color") val avgColor: String?,
    val user: UserDto?,
    @Json(name = "video_files") val videoFiles: List<VideoFile>?,
    @Json(name = "video_pictures") val videoPictures: List<VideoPicture>?
)

data class UserDto(
    val id: Long?,
    val name: String?,
    val url: String?
)

data class VideoFile(
    val id: Long?,
    val quality: String?,
    @Json(name = "file_type") val fileType: String?,
    val width: Int?,
    val height: Int?,
    val fps: Float?,
    val link: String?,
    val size: Long?
)

data class VideoPicture(
    val id: Long?,
    val nr: Int?,
    val picture: String?
)