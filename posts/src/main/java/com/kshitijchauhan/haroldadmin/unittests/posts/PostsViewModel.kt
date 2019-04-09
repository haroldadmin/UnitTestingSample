package com.kshitijchauhan.haroldadmin.unittests.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Post
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class PostsViewModel(private val postsRepository: PostsRepository,
                     private val userId: Int) : ViewModel(), CoroutineScope {

    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>>
        get() = _posts

    init {
        Timber.d("Fetching posts for $userId")
        launch {
            getPostsForUser(userId)
        }
    }

    suspend fun getPostsForUser(id: Int) {
        val posts = withContext(Dispatchers.IO) {
            postsRepository.getPostsForUserAsync(id).await()
        }
        _posts.value = posts
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
