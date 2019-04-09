package com.kshitijchauhan.haroldadmin.unittests.posts

import androidx.recyclerview.widget.DiffUtil
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Post

class PostsDiffCallback: DiffUtil.ItemCallback<Post>() {

    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}