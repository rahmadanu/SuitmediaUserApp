package com.suitmedia.suitmediauserapp.ui.first

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.suitmedia.suitmediauserapp.R
import com.suitmedia.suitmediauserapp.databinding.ActivityPalindromeCheckerBinding
import com.suitmedia.suitmediauserapp.ui.second.SelectedUserActivity

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
                val palindromeField = binding.etPalindrome.text.toString().filter { it.isWhitespace().not() }
                if (validateInput(binding.etPalindrome)) {
                    isPalindrome(palindromeField)
                }
            }
            btnNext.setOnClickListener {
                val name = binding.etName.text.toString()
                if (validateInput(binding.etName)) {
                    startActivity(Intent(this@PalindromeCheckerActivity, SelectedUserActivity::class.java).apply {
                        putExtra(SelectedUserActivity.EXTRA_NAME, name)
                    })
                }
            }
        }
    }

    private fun isPalindrome(palindromeField: String) {
        val palindromeFieldReversed = palindromeField.reversed()
        if (palindromeField.equals(palindromeFieldReversed, ignoreCase = true)) {
            showDialog("isPalindrome")
        } else {
            showDialog("not palindrome")
        }
        Log.d("test", "$palindromeField $palindromeFieldReversed")
    }

    private fun showDialog(message: String) {
        MaterialAlertDialogBuilder(this)
            .setMessage(message)
            .setPositiveButton(resources.getString(R.string.OK)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun validateInput(input: EditText): Boolean {
        var isValid = true

        if (input.text.isEmpty()) {
            isValid = false
            input.error = "Field must not be empty"
        }
        return isValid
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}