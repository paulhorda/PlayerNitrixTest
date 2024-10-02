package com.example.playernitrixtest.data.repository

import com.example.playernitrixtest.data.local.dao.VideoDao
import com.example.playernitrixtest.data.mapper.VideoItemMapper
import com.example.playernitrixtest.data.network.api.VideoApi
import com.example.playernitrixtest.domain.model.Video
import com.example.playernitrixtest.domain.repository.VideoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val api: VideoApi,
    private val videoDao: VideoDao,
    private val mapper: VideoItemMapper
) : VideoRepository {

    override suspend fun getVideoList(): Flow<List<Video>> {
        return videoDao.getAllVideos().map { elements ->
            elements.map { element ->
                mapper.mapToItem(element)
            }
        }
    }

    override suspend fun updateVideoList(): Flow<Unit> = flow {
        val listVideoDto = api.getPopularVideo().videos

        videoDao.deleteOldVideos(listVideoDto
            ?.map {
                it.id ?: 0
            } ?: emptyList()
        )

        videoDao.insertAll(
            listVideoDto?.map { videoDto ->
                mapper.mapToEntityItem(videoDto)
            } ?: emptyList()
        )

        emit(Unit)
    }
}