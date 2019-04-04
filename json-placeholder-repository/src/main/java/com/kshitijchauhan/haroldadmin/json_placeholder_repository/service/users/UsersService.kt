package com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.users

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

internal interface UsersService {

    @GET("users")
    fun getUsers(): Single<List<User>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id: Int): Single<User>
}