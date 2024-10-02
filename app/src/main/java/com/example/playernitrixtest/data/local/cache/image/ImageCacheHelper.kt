package com.example.playernitrixtest.data.local.cache.image

interface ImageCacheHelper {
    suspend fun downloadAndCacheImage(imageUrl: String): String
}