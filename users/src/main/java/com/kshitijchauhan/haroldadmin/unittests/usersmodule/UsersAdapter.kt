package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import com.kshitijchauhan.haroldadmin.unittests.usersmodule.databinding.ItemUserBinding
import timber.log.Timber

class UsersAdapter(diffCallback: UsersDiffCallback) : ListAdapter<User, UsersViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Timber.d("Creating new ViewHolder")
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        Timber.d("Binding user: ${getItem(position)}")
        holder.bind(getItem(position))
    }
}

