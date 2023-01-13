package com.suitmedia.suitmediauserapp.ui.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suitmedia.suitmediauserapp.R
import com.suitmedia.suitmediauserapp.databinding.ActivitySelectedUserBinding

class SelectedUserActivity : AppCompatActivity() {

    private var _binding: ActivitySelectedUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySelectedUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.apply {
            tvName.text = intent.getStringExtra(EXTRA_NAME)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EXTRA_NAME = "name"
    }
}