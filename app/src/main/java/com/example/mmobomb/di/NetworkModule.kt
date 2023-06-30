package com.example.mmobomb.di

import com.example.mmobomb.data.datasource.GameApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single<Retrofit> { provideRetrofit() }
    single<GameApi> { provideGameApi(get()) }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideGameApi(retrofit: Retrofit): GameApi =
    retrofit.create(GameApi::class.java)

private const val BASE_URL = "https://www.mmobomb.com"