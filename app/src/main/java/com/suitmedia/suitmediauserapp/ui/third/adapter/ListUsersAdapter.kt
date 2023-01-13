package com.suitmedia.suitmediauserapp.ui.third.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suitmedia.suitmediauserapp.R
import com.suitmedia.suitmediauserapp.data.remote.model.user.User
import com.suitmedia.suitmediauserapp.databinding.ItemUserBinding

class ListUsersAdapter(
    private val onClick: (String) -> Unit
): PagingDataAdapter<User, ListUsersAdapter.ListUsersViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    class ListUsersViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(user: User, onClick: (String) -> Unit) {
                with(binding) {
                    with(user) {
                        val fulLName = itemView.resources.getString(R.string.full_name, firstName, lastName)
                        tvFullName.text = fulLName
                        tvEmail.text = email
                        Glide.with(itemView.context)
                            .load(avatar)
                            .placeholder(R.drawable.ic_photo)
                            .circleCrop()
                            .into(ivAvatar)

                        itemView.setOnClickListener {
                            onClick(fulLName)
                        }
                    }
                }
            }
    }

    override fun onBindViewHolder(holder: ListUsersViewHolder, position: Int) {
        val user = getItem(position)
        user?.let { holder.bind(it, onClick) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUsersViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListUsersViewHolder(binding)
    }
}