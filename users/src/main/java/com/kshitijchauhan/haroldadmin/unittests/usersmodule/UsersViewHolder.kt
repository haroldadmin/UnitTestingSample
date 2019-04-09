package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import androidx.recyclerview.widget.RecyclerView
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import com.kshitijchauhan.haroldadmin.unittests.usersmodule.databinding.ItemUserBinding

class UsersViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(userItem: User, calbacks: Callbacks) {
        binding.apply {
            user = userItem
            root.setOnClickListener { calbacks.onUserClick() }
            root.setOnLongClickListener { calbacks.onUserLongClick(userItem) }
            executePendingBindings()
        }
    }

    interface Callbacks {
        fun onUserClick()
        fun onUserLongClick(user: User): Boolean
    }
}