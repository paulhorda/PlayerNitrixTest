package com.example.playernitrixtest.domain.usecase

import com.example.playernitrixtest.domain.model.Video
import kotlinx.coroutines.flow.Flow

interface GetVideoListUseCase {
    suspend fun invoke(): Flow<Result<List<Video>>>
}