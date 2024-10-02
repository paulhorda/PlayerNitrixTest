package com.example.playernitrixtest.di

import android.content.Context
import com.example.playernitrixtest.data.local.cache.image.ImageCacheHelper
import com.example.playernitrixtest.data.local.cache.image.ImageCacheHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ImageCacheModule {

    @Provides
    @Singleton
    fun provideImageCacheHelper(@ApplicationContext context: Context): ImageCacheHelper {
        return ImageCacheHelperImpl(context)
    }
}
