package com.suitmedia.suitmediauserapp.ui.third.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suitmedia.suitmediauserapp.databinding.ItemFooterLoadStateBinding

class FooterLoadStateAdapter(
    private val retry: () -> Unit
): LoadStateAdapter<FooterLoadStateAdapter.FooterLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: FooterLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): FooterLoadStateViewHolder {
        val binding = ItemFooterLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FooterLoadStateViewHolder(binding, retry)
    }

    class FooterLoadStateViewHolder(
        private val binding: ItemFooterLoadStateBinding,
        retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnRetry.setOnClickListener { retry.invoke() }
        }

        fun bind(loadState: LoadState) {
            when (loadState) {
                is LoadState.NotLoading -> {
                    binding.pbLoading.isVisible = false
                    binding.btnRetry.isVisible = false
                }
                is LoadState.Loading -> {
                    binding.pbLoading.isVisible = true
                    binding.btnRetry.isVisible = false
                }
                is LoadState.Error -> {
                    binding.pbLoading.isVisible = false
                    binding.btnRetry.isVisible = true
                    Toast.makeText(itemView.context, loadState.error.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}