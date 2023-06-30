package com.example.mmobomb.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.mmobomb.data.datasource.GameApi
import com.example.mmobomb.data.datasource.GamesPagingSource
import com.example.mmobomb.data.model.toDomain
import com.example.mmobomb.domain.model.GameDetailInfo
import com.example.mmobomb.domain.model.GamesInfoWithCategory
import com.example.mmobomb.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow

class GameRepositoryImpl(
    private val api: GameApi
) : GameRepository {

    override suspend fun gamesList(): Flow<PagingData<GamesInfoWithCategory>> =
        Pager(PagingConfig(PAGE_SIZE), null) { GamesPagingSource(api) }.flow

    override suspend fun gameDetail(gameId: Int): GameDetailInfo = api.getGameInfo(gameId).toDomain()

    private companion object {

        const val PAGE_SIZE = 2
    }
}