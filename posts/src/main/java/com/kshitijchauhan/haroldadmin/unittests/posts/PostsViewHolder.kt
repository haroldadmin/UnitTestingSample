package com.kshitijchauhan.haroldadmin.unittests.posts

import androidx.recyclerview.widget.RecyclerView
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Post
import com.kshitijchauhan.haroldadmin.unittests.posts.databinding.ItemPostBinding

class PostsViewHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(postItem: Post) {
        binding.apply {
            post = postItem
            executePendingBindings()
        }
    }
}
