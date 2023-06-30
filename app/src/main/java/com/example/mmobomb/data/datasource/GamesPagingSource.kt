package com.example.mmobomb.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mmobomb.data.model.GamesCategory
import com.example.mmobomb.data.model.toDomain
import com.example.mmobomb.domain.model.GamesInfoWithCategory

class GamesPagingSource(private val api: GameApi) :
    PagingSource<String, GamesInfoWithCategory>() {

    private val categoryArray = GamesCategory.values().map { it.responseName }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, GamesInfoWithCategory> = try {
        val category = params.key ?: categoryArray[0]

        val response = api.getGamesByCategory(category)

        val nextCategoryIndex = categoryArray.indexOf(category) + 1
        val nextCategory = if (nextCategoryIndex < categoryArray.size) categoryArray[nextCategoryIndex] else null

        LoadResult.Page(
            data = listOf(
                GamesInfoWithCategory(
                    category = category,
                    games = response.map { it.toDomain() }
                )
            ),
            prevKey = null,
            nextKey = nextCategory
        )
    } catch (e: Exception) {
        LoadResult.Error(e)
    }

    override fun getRefreshKey(state: PagingState<String, GamesInfoWithCategory>): String =
        categoryArray[state.anchorPosition ?: 0]
}