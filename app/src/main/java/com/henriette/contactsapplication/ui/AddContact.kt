package com.henriette.contactsapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.henriette.contactsapplication.R
import com.henriette.contactsapplication.databinding.ActivityAddContactBinding
import com.henriette.contactsapplication.model.Contact
import com.henriette.contactsapplication.viewmodel.ContactsViewModel

class AddContact : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactViewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
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
            binding.etAddName.error = getString(R.string.name_required)

            error = true
        }
        if (addPhoneNumber.isBlank()) {
            binding.etAddPhoneNumber.error = getString(R.string.number_required)
            error = true
        }
        if (addEmail.isBlank()) {
            binding.etAddEmail.error = getString(R.string.email_required)
            error = true
        }

        if (!error) {
            val newContact=Contact(0, avatar ="",addName,addPhoneNumber,addEmail,)
            contactViewModel.saveContact(newContact)
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