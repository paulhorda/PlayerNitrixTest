package com.example.playernitrixtest.data.mapper

import com.example.playernitrixtest.data.local.cache.image.ImageCacheHelper
import com.example.playernitrixtest.data.local.entity.VideoEntity
import com.example.playernitrixtest.data.network.model.VideoDto
import com.example.playernitrixtest.domain.model.Video
import com.example.playernitrixtest.utils.Constants.DEFAULT_PERMISSION
import javax.inject.Inject

internal class VideoItemMapperImpl @Inject constructor(
    private val imageCacheHelper: ImageCacheHelper
) : VideoItemMapper {

    override fun mapToItem(item: VideoDto): Video {
        with(item) {
            val file = videoFiles
                ?.find {
                    it.height == DEFAULT_PERMISSION
                } ?: videoFiles?.first()

            return Video(
                id ?: 0,
                image ?: "",
                duration ?: 0,
                file?.quality ?: "",
                file?.link ?: "",
                file?.width ?: 0,
                file?.height ?: 0,
                user?.name ?: ""
            )
        }
    }

    override fun mapToItem(item: VideoEntity): Video {
        with(item) {
            return Video(
                id,
                image,
                duration,
                quality,
                link,
                width,
                height,
                name
            )
        }
    }

    override suspend fun mapToEntityItem(item: VideoDto): VideoEntity {
        val localImagePath = imageCacheHelper.downloadAndCacheImage(
            item.image ?: ""
        )

        with(item) {
            return VideoEntity(
                id = id ?: 0,
                image = localImagePath,
                duration = duration ?: 0,
                quality = videoFiles?.firstOrNull()?.quality ?: "Unknown",
                link = videoFiles?.firstOrNull()?.link ?: "",
                width = width ?: 0,
                height = height ?: 0,
                name = user?.name ?: ""
            )
        }
    }
}