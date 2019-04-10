package com.kshitijchauhan.haroldadmin.unittests.comments

import androidx.recyclerview.widget.DiffUtil
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Comment

class CommentsDiffCallback: DiffUtil.ItemCallback<Comment>() {

    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem == newItem
    }
}