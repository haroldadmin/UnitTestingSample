package com.kshitijchauhan.haroldadmin.unittests.posts

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.posts.PostsService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val postsModule = module {

    single { get<Retrofit>().create(PostsService::class.java) }
    single { PostsRepository(get<PostsService>()) }

    viewModel { (userId: Int) -> PostsViewModel(get<PostsRepository>(), userId) }

    factory { PostsDiffCallback() }
    factory { (callbacks: PostsViewHolder.Callbacks) -> PostsAdapter(get<PostsDiffCallback>(), callbacks) }
}