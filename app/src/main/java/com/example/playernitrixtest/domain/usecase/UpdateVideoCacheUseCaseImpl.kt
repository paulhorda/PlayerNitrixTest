package com.example.playernitrixtest.domain.usecase

import com.example.playernitrixtest.di.IoDispatcher
import com.example.playernitrixtest.domain.repository.VideoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateVideoCacheUseCaseImpl @Inject constructor(
    private val repository: VideoRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : UpdateVideoCacheUseCase {

    override suspend fun invoke(): Flow<Result<Unit>> {
        return withContext(ioDispatcher) {
            repository.updateVideoList()
                .map {
                    Result.success(Unit)
                }
                .catch {
                    emit(Result.failure(it))
                }
        }
    }
}