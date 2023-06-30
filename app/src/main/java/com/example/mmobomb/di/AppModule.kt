package com.example.mmobomb.di

import com.example.mmobomb.data.repository.GameRepositoryImpl
import com.example.mmobomb.domain.repository.GameRepository
import com.example.mmobomb.domain.usecase.GetCategoryListWithGamesUseCase
import com.example.mmobomb.domain.usecase.GetDetailGameInfoUseCase
import com.example.mmobomb.presentation.viewmodel.GameDetailViewModel
import com.example.mmobomb.presentation.viewmodel.GamesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<GameRepository> { GameRepositoryImpl(get()) }

    single<GetCategoryListWithGamesUseCase> { GetCategoryListWithGamesUseCase(get()) }
    single<GetDetailGameInfoUseCase> { GetDetailGameInfoUseCase(get()) }

    viewModel<GamesListViewModel> { GamesListViewModel(get()) }
    viewModel<GameDetailViewModel> { GameDetailViewModel(get()) }
}