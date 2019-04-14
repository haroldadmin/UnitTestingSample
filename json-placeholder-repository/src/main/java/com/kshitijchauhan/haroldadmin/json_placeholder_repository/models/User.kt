package com.kshitijchauhan.haroldadmin.json_placeholder_repository.models

import com.squareup.moshi.Json

data class User(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "username") val username: String,
    @field:Json(name = "email") val email: String,
    @field:Json(name = "address") val address: Address,
    @field:Json(name = "phone") val phone: String,
    @field:Json(name = "website") val website: String,
    @field:Json(name = "company") val company: Company
) {
    companion object {
        fun emptyUser(): User {
            return User(0, "", "", "", Address.emptyAddress(), "", "", Company.emptyCompany())
        }
    }
}