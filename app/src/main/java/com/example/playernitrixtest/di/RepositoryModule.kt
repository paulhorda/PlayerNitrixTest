package com.example.playernitrixtest.di

import com.example.playernitrixtest.data.repository.VideoRepositoryImpl
import com.example.playernitrixtest.domain.repository.VideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindVideoRepository(videoRepositoryImpl: VideoRepositoryImpl): VideoRepository
}