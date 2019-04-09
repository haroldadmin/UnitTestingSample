package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import android.text.method.LinkMovementMethod
import androidx.recyclerview.widget.RecyclerView
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import com.kshitijchauhan.haroldadmin.unittests.usersmodule.databinding.ItemUserBinding

class UsersViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User) {
        binding.user = user
        binding.executePendingBindings()
    }
}