package com.suitmedia.suitmediauserapp.ui.third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suitmedia.suitmediauserapp.R
import com.suitmedia.suitmediauserapp.databinding.ActivityChooseUserBinding

class ChooseUserActivity : AppCompatActivity() {

    private var _binding: ActivityChooseUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityChooseUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}