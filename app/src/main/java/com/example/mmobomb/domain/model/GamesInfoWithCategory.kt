package com.example.mmobomb.domain.model

data class GamesInfoWithCategory(
    val category: String,
    val games: List<GameBaseInfo>
)
