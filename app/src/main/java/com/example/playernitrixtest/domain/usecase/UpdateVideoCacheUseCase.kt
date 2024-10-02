package com.example.playernitrixtest.domain.usecase

import kotlinx.coroutines.flow.Flow

interface UpdateVideoCacheUseCase {
    suspend fun invoke(): Flow<Result<Unit>>
}
