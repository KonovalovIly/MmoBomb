package com.example.mmobomb.domain.usecase

import com.example.mmobomb.domain.repository.GameRepository

class GetDetailGameInfoUseCase(private val repository: GameRepository) {

    suspend operator fun invoke(gameId: Int) = repository.gameDetail(gameId)
}