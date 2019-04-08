package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import kotlinx.coroutines.*

class UsersViewModel(private val usersRepository: UsersRepository) : ViewModel(), CoroutineScope by MainScope() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    suspend fun getUsers() {
        launch {
            val users: List<User> = withContext(Dispatchers.IO) { usersRepository.getUsersAsync().await() }
            _users.value = users
        }
    }
}
