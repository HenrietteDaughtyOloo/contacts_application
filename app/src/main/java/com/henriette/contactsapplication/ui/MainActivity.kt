package com.henriette.contactsapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.henriette.contactsapplication.databinding.ActivityMainBinding
import com.henriette.contactsapplication.model.Contact
import com.henriette.contactsapplication.viewmodel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    lateinit var btnAddContact: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fabAddAContact.setOnClickListener {
            val intent=Intent(this,AddContact::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        //here an issue
        contactsViewModel.getContacts().observe(this, Observer { contactList ->
            displayContact(contactList)
        })

        binding.fabAddAContact.setOnClickListener {
            startActivity(Intent(this, AddContact::class.java))
        }
    }


    fun displayContact(contactList:List<Contact>) {
        val contactAdapter=ContactAdapter(contactList, this)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = contactAdapter

    }

}