package com.kshitijchauhan.haroldadmin.unittests.posts

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Post
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.posts.PostsService
import kotlinx.coroutines.Deferred

class PostsRepository(private val postsService: PostsService) {

    fun getPostsForUserAsync(id: Int): Deferred<List<Post>> {
        return postsService.getPostsForUser(id)
    }
}