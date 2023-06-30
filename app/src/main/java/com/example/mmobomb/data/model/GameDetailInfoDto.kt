package com.example.mmobomb.data.model

import com.example.mmobomb.domain.model.GameDetailInfo
import com.google.gson.annotations.SerializedName

data class GameDetailInfoDto(
    @SerializedName("description")
    val description: String?,
    @SerializedName("developer")
    val developer: String?,
    @SerializedName("game_url")
    val gameUrl: String?,
    @SerializedName("genre")
    val genre: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("minimum_system_requirements")
    val minimumSystemRequirements: MinimumSystemRequirementsDto?,
    @SerializedName("platform")
    val platform: String?,
    @SerializedName("profile_url")
    val profileUrl: String?,
    @SerializedName("publisher")
    val publisher: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("screenshots")
    val screenshots: List<ScreenshotDto>?,
    @SerializedName("short_description")
    val shortDescription: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String?
)

fun GameDetailInfoDto.toDomain() = GameDetailInfo(
    description = description.orEmpty(),
    developer = developer.orEmpty(),
    gameUrl = gameUrl.orEmpty(),
    genre = genre.orEmpty(),
    id = id,
    minimumSystemRequirements = minimumSystemRequirements?.toDomain(),
    platform = platform.orEmpty(),
    profileUrl = profileUrl.orEmpty(),
    publisher = publisher.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
    title = title.orEmpty(),
    status = status.orEmpty(),
    thumbnail = thumbnail,
    shortDescription = shortDescription.orEmpty(),
    screenshots = screenshots.orEmpty().map { it.image }
)