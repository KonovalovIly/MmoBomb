package com.example.mmobomb.data.model

import com.example.mmobomb.domain.model.MinimumSystemRequirements
import com.google.gson.annotations.SerializedName

data class MinimumSystemRequirementsDto(
    @SerializedName("graphics") val graphics: String?,
    @SerializedName("memory") val memory: String?,
    @SerializedName("os") val os: String?,
    @SerializedName("processor") val processor: String?,
    @SerializedName("storage") val storage: String?
)

fun MinimumSystemRequirementsDto.toDomain() = MinimumSystemRequirements(
    graphics = graphics.orEmpty(),
    memory = memory.orEmpty(),
    os = os.orEmpty(),
    processor = processor.orEmpty(),
    storage = storage.orEmpty()
)