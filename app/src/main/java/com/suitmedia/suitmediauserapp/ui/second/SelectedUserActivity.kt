package com.suitmedia.suitmediauserapp.ui.second

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.suitmedia.suitmediauserapp.databinding.ActivitySelectedUserBinding
import com.suitmedia.suitmediauserapp.ui.third.ChooseUserActivity

class SelectedUserActivity : AppCompatActivity() {

    private var _binding: ActivitySelectedUserBinding? = null
    private val binding get() = _binding!!

    private val selectedUserResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result?.data?.getStringExtra(EXTRA_NAME)?.let {
                    binding.tvSelectedUserName.text = it
                }
            }
        }

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
                selectedUserResult.launch(Intent(this@SelectedUserActivity, ChooseUserActivity::class.java))
            }
            ivBack.setOnClickListener {
                finish()
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