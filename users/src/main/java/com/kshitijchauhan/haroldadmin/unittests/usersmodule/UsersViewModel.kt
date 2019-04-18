package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UsersViewModel(private val usersRepository: UsersRepository) : ViewModel(), CoroutineScope {

    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        launch {
            getUsers()
        }
    }

    suspend fun getUsers() {
        val users: List<User> = withContext(Dispatchers.IO) {
            usersRepository.getUsersAsync().await()
        }
        _users.value = users
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
