package com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.posts

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Post
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsService {

    @GET("posts")
    fun getPosts(): Deferred<Response<List<Post>>>

    @GET("posts/{id}")
    fun getPostById(@Path("id") id: Int): Deferred<Response<Post>>

}