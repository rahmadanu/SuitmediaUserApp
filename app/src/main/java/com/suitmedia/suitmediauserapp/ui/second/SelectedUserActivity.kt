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
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}