package com.kshitijchauhan.haroldadmin.json_placeholder_repository.models

import com.squareup.moshi.Json

data class Comment(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "postId") val postId: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "email") val email: String,
    @field:Json(name = "body") val body: String
)