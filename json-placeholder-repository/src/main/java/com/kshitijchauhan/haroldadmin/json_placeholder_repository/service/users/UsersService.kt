package com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.users

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {

    @GET("users")
    fun getUsers(): Deferred<List<User>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id: Int): Deferred<User>
}