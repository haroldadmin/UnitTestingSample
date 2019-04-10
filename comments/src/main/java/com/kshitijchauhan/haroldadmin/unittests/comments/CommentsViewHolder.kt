package com.kshitijchauhan.haroldadmin.unittests.comments

import androidx.recyclerview.widget.RecyclerView
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Comment
import com.kshitijchauhan.haroldadmin.unittests.comments.databinding.ItemCommentBinding

class CommentsViewHolder(private val binding: ItemCommentBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(commentItem: Comment) {
        binding.apply {
            comment = commentItem
            executePendingBindings()
        }
    }
}