package com.suitmedia.suitmediauserapp.ui.third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.suitmedia.suitmediauserapp.databinding.ActivityChooseUserBinding
import com.suitmedia.suitmediauserapp.ui.third.adapter.ListUsersAdapter
import dagger.hilt.android.AndroidEntryPoint

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
        getListUsers()
        observeListUsers()
    }

    private fun initList() {
        binding.rvListUsers.apply {
            layoutManager = LinearLayoutManager(this@ChooseUserActivity)
            adapter = this@ChooseUserActivity.adapter
        }
    }

    private fun observeListUsers() {
        viewModel.listUsers.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }

    private fun getListUsers() {
        viewModel.getListUsers()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}