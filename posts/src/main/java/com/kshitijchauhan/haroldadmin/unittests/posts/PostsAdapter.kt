package com.kshitijchauhan.haroldadmin.unittests.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Post
import com.kshitijchauhan.haroldadmin.unittests.posts.databinding.ItemPostBinding

class PostsAdapter(diffCallback: PostsDiffCallback,
                   private val callbacks: PostsViewHolder.Callbacks): ListAdapter<Post, PostsViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.bind(getItem(position), callbacks)
    }

}