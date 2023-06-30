package com.example.mmobomb.data.datasource

import com.example.mmobomb.data.model.GameBaseInfoDto
import com.example.mmobomb.data.model.GameDetailInfoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET(GAMES_PATH)
    suspend fun getGamesByCategory(@Query(CATEGORY_QUERY) category: String): List<GameBaseInfoDto>

    @GET(GAME_PATH)
    suspend fun getGameInfo(@Query(GAME_ID_QUERY) id: Int): GameDetailInfoDto

    private companion object {

        const val GAMES_PATH = "/api1/games"
        const val GAME_PATH = "/api1/game"
        const val CATEGORY_QUERY = "category"
        const val GAME_ID_QUERY = "id"
    }
}