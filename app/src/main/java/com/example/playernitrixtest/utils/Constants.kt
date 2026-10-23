package com.example.playernitrixtest.utils

import com.example.playernitrixtest.BuildConfig

object Constants {
    const val DEFAULT_PERMISSION = 720
    const val DATABASE_NAME = "PlayerNitrixTest"
    const val IMAGE_CACHE_NAME = "images_cache"
    const val FILE_TYPE = ".jpg"
    const val VIDEO_LIST_ENDPOINT = "videos/popular"
    const val PAGE ="page"
    const val PER_PAGE = "per_page"
    const val HEADER_KEY = "Authorization"
    val HEADER_VALUE = BuildConfig.PEXELS_API_KEY
}