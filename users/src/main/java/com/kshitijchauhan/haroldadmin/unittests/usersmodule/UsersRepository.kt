package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.users.UsersService
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UsersRepository (private val usersService: UsersService) {

    fun getUsersAsync(): Deferred<List<User>> {
        return usersService.getUsers()
    }
}