package com.kshitijchauhan.haroldadmin.json_placeholder_repository.models

import com.squareup.moshi.Json

data class Company(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "catchPhrase") val catchPhrase: String,
    @field:Json(name = "bs") val bs: String
)