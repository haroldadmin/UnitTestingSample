package com.kshitijchauhan.haroldadmin.unittests.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Comment
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CommentsViewModel(private val commentsRepository: CommentsRepository,
                        private val postId: Int) : ViewModel(), CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>>
        get() = _comments


    init {
        launch { getCommentsForPost(postId) }
    }

    suspend fun getCommentsForPost(postId: Int) {
        val comments = withContext(Dispatchers.IO) {
            commentsRepository.getCommentsForPostAsync(postId).await()
        }
        _comments.value = comments
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
