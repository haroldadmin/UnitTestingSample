package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import androidx.recyclerview.widget.DiffUtil
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User

class UsersDiffCallback: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

}