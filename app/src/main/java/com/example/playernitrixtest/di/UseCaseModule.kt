package com.example.playernitrixtest.di

import com.example.playernitrixtest.domain.usecase.GetVideoListUseCase
import com.example.playernitrixtest.domain.usecase.GetVideoListUseCaseImpl
import com.example.playernitrixtest.domain.usecase.UpdateVideoCacheUseCase
import com.example.playernitrixtest.domain.usecase.UpdateVideoCacheUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetVideoListUseCase(getVideoListUseCaseImpl: GetVideoListUseCaseImpl): GetVideoListUseCase

    @Binds
    fun bindUpdateVideoCacheUseCase(updateVideoCacheUseCaseImpl: UpdateVideoCacheUseCaseImpl): UpdateVideoCacheUseCase
}