package com.example.playernitrixtest.domain.model

data class Video(
    val id: Int,
    val image: String,
    val duration: Int,
    val quality: String,
    val link: String,
    val width: Int,
    val height: Int,
    val name: String
)
