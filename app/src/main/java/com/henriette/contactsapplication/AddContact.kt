package com.henriette.contactsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.henriette.contactsapplication.databinding.ActivityAddContactBinding
import com.henriette.contactsapplication.databinding.ActivityMainBinding

class AddContact : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            validateAddContact()
        }
    }

    fun validateAddContact() {
        clearErrors()
        val addName = binding.etAddName.text.toString()
        val addPhoneNumber = binding.etAddPhoneNumber.text.toString()
        val addEmail = binding.etAddEmail.text.toString()
        var error = false
        if (addName.isBlank()) {
            binding.etAddName.error = "A Name is needed to proceed"
            error = true
        }
        if (addPhoneNumber.isBlank()) {
            binding.etAddPhoneNumber.error = "Name is needed to Proceed"
            error = true
        }
        if (addEmail.isBlank()) {
            binding.etAddEmail.error = "Add an Email to continue"
            error = true
        }
//        if (!error) {
//            val addedName = addName
//        }
        if (!error) {
            Toast.makeText(
                this, "Contact added Successfully", Toast.LENGTH_LONG
            )
                .show()
            finish()

        }

    }

    fun clearErrors() {
        binding.etAddName.error = null
        binding.etAddPhoneNumber.error = null
        binding.etAddEmail.error = null
    }


}