package com.example.playernitrixtest.di

import android.content.Context
import androidx.room.Room
import com.example.playernitrixtest.data.local.AppDatabase
import com.example.playernitrixtest.data.local.dao.VideoDao
import com.example.playernitrixtest.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideVideoDao(appDatabase: AppDatabase): VideoDao =
        appDatabase.videoDao()
}