package com.example.mmobomb.domain.model

data class GameDetailInfo(
    val description: String,
    val developer: String,
    val gameUrl: String,
    val genre: String,
    val id: Int,
    val minimumSystemRequirements: MinimumSystemRequirements?,
    val platform: String,
    val profileUrl: String,
    val publisher: String,
    val releaseDate: String,
    val screenshots: List<String>,
    val shortDescription: String,
    val status: String,
    val thumbnail: String,
    val title: String
)