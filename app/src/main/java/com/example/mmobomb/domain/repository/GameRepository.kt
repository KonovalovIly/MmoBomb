package com.example.mmobomb.domain.repository

import androidx.paging.PagingData
import com.example.mmobomb.domain.model.GameDetailInfo
import com.example.mmobomb.domain.model.GamesInfoWithCategory
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    suspend fun gamesList(): Flow<PagingData<GamesInfoWithCategory>>

    suspend fun gameDetail(gameId: Int): GameDetailInfo
}