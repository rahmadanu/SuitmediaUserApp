package com.suitmedia.suitmediauserapp.ui.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.suitmedia.suitmediauserapp.R
import com.suitmedia.suitmediauserapp.databinding.ActivityPalindromeCheckerBinding

class PalindromeCheckerActivity : AppCompatActivity() {

    private var _binding: ActivityPalindromeCheckerBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPalindromeCheckerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.apply {

            btnCheck.setOnClickListener {
                val palindromeField = binding.etPalindrome.text.toString()
                isPalindrome(palindromeField)
            }
            btnNext.setOnClickListener {
                //
                if (validateInput()) {

                }
            }
        }
    }

    private fun isPalindrome(palindromeField: String) {
        val palindromeFieldReversed = palindromeField.reversed()
        Log.d("test", "$palindromeField $palindromeFieldReversed")
        if (palindromeField.equals(palindromeFieldReversed, ignoreCase = true)) {
            showDialog("isPalindrome")
        } else {
            showDialog("not palindrome")
        }
    }

    private fun showDialog(message: String) {
        MaterialAlertDialogBuilder(this)
            .setMessage(message)
            .setPositiveButton(resources.getString(R.string.OK)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun validateInput(): Boolean {
        var isValid = true
        val name = binding.etName.text.toString()
        val palindrome = binding.etPalindrome.text.toString()

        if (name.isEmpty()) {
            isValid = false
            binding.etName.error = "Name must not be empty"
        }
        if (palindrome.isEmpty()) {
            isValid = false
            binding.etName.error = "Palindrome must not be empty"
        }
        return isValid
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}