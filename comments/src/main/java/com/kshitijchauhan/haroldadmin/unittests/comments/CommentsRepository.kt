package com.kshitijchauhan.haroldadmin.unittests.comments

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.comments.CommentsService

class CommentsRepository(private val commentsService: CommentsService) {

    fun getCommentsForPostAsync(postId: Int) = commentsService.getCommentForPost(postId)
}