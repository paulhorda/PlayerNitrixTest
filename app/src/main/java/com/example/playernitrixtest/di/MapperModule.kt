package com.example.playernitrixtest.di

import com.example.playernitrixtest.data.local.cache.image.ImageCacheHelper
import com.example.playernitrixtest.data.mapper.VideoItemMapper
import com.example.playernitrixtest.data.mapper.VideoItemMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Singleton
    @Provides
    fun provideVideoItemMapper(imageCacheHelper: ImageCacheHelper): VideoItemMapper =
        VideoItemMapperImpl(imageCacheHelper)
}