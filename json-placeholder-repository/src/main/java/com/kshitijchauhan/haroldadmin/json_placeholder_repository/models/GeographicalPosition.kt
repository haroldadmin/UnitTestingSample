package com.kshitijchauhan.haroldadmin.json_placeholder_repository.models

import com.squareup.moshi.Json

data class GeographicalPosition(
    @field:Json(name = "lat") val latitude: String,
    @field:Json(name = "lng") val longitude: String
)