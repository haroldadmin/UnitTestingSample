package com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.posts

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Post
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

internal interface PostsService {

    @GET("posts")
    fun getPosts(): Single<List<Post>>

    @GET("posts/{id}")
    fun getPostById(@Path("id") id: Int): Single<Post>

}