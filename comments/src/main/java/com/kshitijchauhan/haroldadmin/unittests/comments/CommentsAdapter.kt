package com.kshitijchauhan.haroldadmin.unittests.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Comment
import com.kshitijchauhan.haroldadmin.unittests.comments.databinding.ItemCommentBinding

class CommentsAdapter(diffCallback: CommentsDiffCallback): ListAdapter<Comment, CommentsViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}