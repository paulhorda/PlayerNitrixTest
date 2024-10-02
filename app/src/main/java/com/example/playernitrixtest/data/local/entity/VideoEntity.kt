package com.example.playernitrixtest.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos")
data class VideoEntity(
    @PrimaryKey val id: Int,
    val image: String,
    val duration: Int,
    val quality: String,
    val link: String,
    val width: Int,
    val height: Int,
    val name: String
)