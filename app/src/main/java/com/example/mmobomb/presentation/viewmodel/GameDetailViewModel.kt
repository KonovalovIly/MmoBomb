package com.example.mmobomb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mmobomb.base.viewmodel.BaseGameViewModel
import com.example.mmobomb.domain.model.GameDetailInfo
import com.example.mmobomb.domain.usecase.GetDetailGameInfoUseCase
import kotlinx.coroutines.launch

class GameDetailViewModel(private val gameInfoUseCase: GetDetailGameInfoUseCase) : BaseGameViewModel() {

    private val _gameInfo: MutableLiveData<GameDetailInfo> = MutableLiveData()
    val gameInfo: LiveData<GameDetailInfo>
        get() = _gameInfo

    fun getGameInfo(gameId: Int) {
        viewModelScope.launch {
            startLoad()
            runCatching { gameInfoUseCase(gameId) }
                .onEndLoad()
                .onSuccess { _gameInfo.postValue(it) }
                .onFailure { processError(it) }
        }
    }
}