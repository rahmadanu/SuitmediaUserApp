package com.suitmedia.suitmediauserapp.ui.second

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suitmedia.suitmediauserapp.R
import com.suitmedia.suitmediauserapp.databinding.ActivitySelectedUserBinding
import com.suitmedia.suitmediauserapp.ui.third.ChooseUserActivity

class SelectedUserActivity : AppCompatActivity() {

    private var _binding: ActivitySelectedUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySelectedUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.apply {
            btnChooseAUser.setOnClickListener {
                startActivity(Intent(this@SelectedUserActivity, ChooseUserActivity::class.java))
            }
        }
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