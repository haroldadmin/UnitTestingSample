package com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.comments

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Comment
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CommentsService {

    @GET("comments")
    fun getAllComments(): Deferred<List<Comment>>

    @GET("comments/{id}")
    fun getCommentById(@Path("id") commentId: Int): Deferred<Comment>

    @GET("comments")
    fun getCommentForPost(@Query("postId") postId: Int): Deferred<List<Comment>>
}
