package com.example.mmobomb.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.mmobomb.base.viewmodel.BaseGameViewModel
import com.example.mmobomb.domain.model.GamesInfoWithCategory
import com.example.mmobomb.domain.usecase.GetCategoryListWithGamesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class GamesListViewModel(
    private val categoryListWithGamesUseCase: GetCategoryListWithGamesUseCase
) : BaseGameViewModel() {

    private var _gamesList: Flow<PagingData<GamesInfoWithCategory>>? = null
    val gamesList: Flow<PagingData<GamesInfoWithCategory>>
        get() = _gamesList ?: flowOf()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            startLoad()
            runCatching { categoryListWithGamesUseCase().cachedIn(viewModelScope) }
                .onEndLoad()
                .onSuccess { _gamesList = it }
                .onFailure {
                    _gamesList = null
                    processError(it)
                }
        }
    }
}