package com.example.mmobomb.domain.usecase

import com.example.mmobomb.domain.repository.GameRepository

class GetCategoryListWithGamesUseCase(private val repository: GameRepository) {

    suspend operator fun invoke() = repository.gamesList()
}