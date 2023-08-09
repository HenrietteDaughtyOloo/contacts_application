package com.henriette.contactsapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.henriette.contactsapplication.R
import com.henriette.contactsapplication.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    var contactId = 0
    lateinit var binding: ActivityContactDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var bundle = intent.extras

        if (bundle!=null){
            contactId= bundle.getInt("CONTACT_ID", 0)
            Toast.makeText(this, "$contactId", Toast.LENGTH_LONG).show()
        }
    }
}