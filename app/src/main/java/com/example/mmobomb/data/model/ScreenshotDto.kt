package com.example.mmobomb.data.model

import com.google.gson.annotations.SerializedName

data class ScreenshotDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String
)