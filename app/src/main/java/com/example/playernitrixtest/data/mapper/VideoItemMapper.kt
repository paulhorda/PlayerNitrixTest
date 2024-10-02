package com.example.playernitrixtest.data.mapper

import com.example.playernitrixtest.data.local.entity.VideoEntity
import com.example.playernitrixtest.data.network.model.VideoDto
import com.example.playernitrixtest.domain.model.Video

interface VideoItemMapper {

    fun mapToItem(item: VideoDto): Video

    fun mapToItem(item: VideoEntity): Video

    suspend fun mapToEntityItem(item: VideoDto): VideoEntity
}