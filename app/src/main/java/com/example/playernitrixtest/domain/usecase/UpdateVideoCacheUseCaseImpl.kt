package com.example.playernitrixtest.domain.usecase

import com.example.playernitrixtest.di.IoDispatcher
import com.example.playernitrixtest.domain.repository.VideoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateVideoCacheUseCaseImpl @Inject constructor(
    private val repository: VideoRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : UpdateVideoCacheUseCase {

    override suspend fun invoke() {
        return withContext(ioDispatcher) {
            runCatching {
                repository.updateVideoList()
            }
        }
    }
}