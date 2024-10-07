package com.example.playernitrixtest.domain.repository

import com.example.playernitrixtest.domain.model.Video
import kotlinx.coroutines.flow.Flow

interface VideoRepository {
    suspend fun getVideoList(): Flow<List<Video>>
    suspend fun updateVideoList()
}