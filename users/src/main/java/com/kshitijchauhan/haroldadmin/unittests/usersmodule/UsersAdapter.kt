package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import com.kshitijchauhan.haroldadmin.unittests.usersmodule.databinding.ItemUserBinding

class UsersAdapter(
    diffCallback: UsersDiffCallback,
    private val callbacks: UsersViewHolder.Callbacks
) : ListAdapter<User, UsersViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(getItem(position), callbacks)
    }
}

