package com.kshitijchauhan.haroldadmin.unittests.comments

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.comments.CommentsService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val commentsModule = module {
    single { get<Retrofit>().create(CommentsService::class.java) }
    single { CommentsRepository(get<CommentsService>()) }

    viewModel { (postId: Int) -> CommentsViewModel(get<CommentsRepository>(), postId) }

    factory { CommentsDiffCallback() }
    factory { CommentsAdapter(get<CommentsDiffCallback>()) }
}