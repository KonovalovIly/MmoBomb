package com.example.mmobomb.domain.model

data class GameBaseInfo(
    val developer: String,
    val gameUrl: String,
    val genre: String,
    val id: Int,
    val platform: String,
    val profileUrl: String,
    val publisher: String,
    val releaseDate: String,
    val shortDescription: String,
    val thumbnail: String,
    val title: String
)