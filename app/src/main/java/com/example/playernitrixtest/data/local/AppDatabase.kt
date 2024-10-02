package com.example.playernitrixtest.data.local

import androidx.annotation.Keep
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.playernitrixtest.data.local.dao.VideoDao
import com.example.playernitrixtest.data.local.entity.VideoEntity

@Keep
@Database(entities = [VideoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun videoDao(): VideoDao
}