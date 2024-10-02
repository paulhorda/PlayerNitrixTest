package com.example.playernitrixtest.domain.usecase

import com.example.playernitrixtest.di.IoDispatcher
import com.example.playernitrixtest.domain.model.Video
import com.example.playernitrixtest.domain.repository.VideoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetVideoListUseCaseImpl @Inject constructor(
    private val repository: VideoRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GetVideoListUseCase {

    override suspend fun invoke(): Flow<Result<List<Video>>> {
        return withContext(ioDispatcher) {
            repository.getVideoList()
                .map { response ->
                    Result.success(response)
                }
                .catch {
                    emit(Result.failure(it))
                }
        }
    }
}