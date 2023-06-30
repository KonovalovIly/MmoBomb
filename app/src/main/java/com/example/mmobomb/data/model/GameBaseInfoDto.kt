package com.example.mmobomb.data.model

import com.example.mmobomb.domain.model.GameBaseInfo
import com.google.gson.annotations.SerializedName

data class GameBaseInfoDto(
    @SerializedName("developer")
    val developer: String?,
    @SerializedName("game_url")
    val gameUrl: String?,
    @SerializedName("genre")
    val genre: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("platform")
    val platform: String?,
    @SerializedName("profile_url")
    val profileUrl: String,
    @SerializedName("publisher")
    val publisher: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("short_description")
    val shortDescription: String?,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String
)

fun GameBaseInfoDto.toDomain() = GameBaseInfo(
    developer = developer.orEmpty(),
    gameUrl = gameUrl.orEmpty(),
    genre = genre.orEmpty(),
    id = id,
    platform = platform.orEmpty(),
    profileUrl = profileUrl,
    publisher = publisher.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
    shortDescription = shortDescription.orEmpty(),
    thumbnail = thumbnail,
    title = title
)