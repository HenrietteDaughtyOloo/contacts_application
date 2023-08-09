package com.henriette.contactsapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.henriette.contactsapplication.R
import com.henriette.contactsapplication.databinding.ActivityContactDetailsBinding
import com.henriette.contactsapplication.model.Contact
import com.henriette.contactsapplication.viewmodel.ContactsViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactDetailsActivity : AppCompatActivity() {
    var contactId = 0
    private lateinit var viewModel: ContactsViewModel

    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.btn.setOnClickListener {
//        }




        viewModel = ContactsViewModel()
        val contactId = intent.getIntExtra("CONTACT_ID", 0)
        viewModel.getContactsById(contactId).observe(this, Observer{ contact ->
            if (contact != null) {
                displayContactDetails(contact)
            } else {
                Toast.makeText(this, "Contact not found", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun displayContactDetails(contact: Contact) {
        binding.tvName.text= contact.dislayName
        binding.tvPhoneNumber.text = contact.phoneNumber
        binding.tvEmail.text = contact.emailAddress
        if (!contact.avatar.isNullOrEmpty()) {
            Picasso
                .get()
                .load(contact.avatar)
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .into(binding.ivImage)
        }
    }}