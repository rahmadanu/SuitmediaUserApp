package com.suitmedia.suitmediauserapp.ui.third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.recyclerview.widget.LinearLayoutManager
import com.suitmedia.suitmediauserapp.data.remote.model.user.User
import com.suitmedia.suitmediauserapp.databinding.ActivityChooseUserBinding
import com.suitmedia.suitmediauserapp.ui.third.adapter.FooterLoadStateAdapter
import com.suitmedia.suitmediauserapp.ui.third.adapter.ListUsersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChooseUserActivity : AppCompatActivity() {

    private var _binding: ActivityChooseUserBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ChooseUserViewModel by viewModels()

    private val adapter: ListUsersAdapter by lazy {
        ListUsersAdapter {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityChooseUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
        observeListUsers()
    }

    private fun initList() {
        binding.rvListUsers.apply {
            layoutManager = LinearLayoutManager(this@ChooseUserActivity)
            adapter = this@ChooseUserActivity.adapter.withLoadStateFooter(
                footer = FooterLoadStateAdapter { this@ChooseUserActivity.adapter.retry() }
            )
        }
    }

    private fun observeListUsers() {
        viewModel.listUsers.observe(this) {
            lifecycleScope.launch(Dispatchers.Main) {
                adapter.loadStateFlow.collectLatest { loadStates ->
                    if (loadStates.refresh is LoadState.Loading) {
                        binding.pbLoading.isVisible = true
                    } else {
                        binding.pbLoading.isVisible = false
                        if (loadStates.refresh is LoadState.Error) {
                            binding.tvEmpty.isVisible = adapter.itemCount < 1
                        }
                    }
                }
            }
            adapter.submitData(lifecycle, it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}