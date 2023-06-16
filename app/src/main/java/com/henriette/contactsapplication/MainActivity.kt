package com.henriette.contactsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.henriette.contactsapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var btnAddContact: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnAddContact.setOnClickListener {
            val intent = Intent(this, AddContact::class.java)
            startActivity(intent)
        }
        displayContact()
    }

    fun displayContact() {

        val contact1 = ContactData(
            "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8cHJvZmlsZSUyMHBpY3R1cmVzfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60",
            "Barachicho Mee",
            "0791653445",
            "brchicho@gmail.com"
        )
        val contact2 = ContactData(
            "https://images.unsplash.com/photo-1471898554234-bcbfedd35134?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fHByb2ZpbGUlMjBwaWN0dXJlc3xlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60",
            "Trcy ",
            "0706553445",
            "trcy@gmail.com"
        )
        val contact3 = ContactData(
            "https://images.unsplash.com/photo-1463453091185-61582044d556?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cHJvZmlsZSUyMHBpY3R1cmVzfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60",
            "Jefferey Jmes",
            "0711153445",
            "jeff@gmail.com"
        )
        val contact4 = ContactData(
            "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8cHJvZmlsZSUyMHBpY3R1cmVzfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60",
            "Lucy Monic",
            "0734553445",
            "monic@gmail.com"
        )
        val contact5 = ContactData(
            "https://images.unsplash.com/photo-1522307837370-cc113a36b784?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8cHJvZmlsZSUyMHBpY3R1cmVzfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60",
            "Boaz",
            "07890153445",
            "boaz@gmail.com"
        )
        val contact6 = ContactData(
            "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cHJvZmlsZSUyMHBpY3R1cmVzfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60",
            "Maina King'ang'i",
            "0711153445",
            "droid@gmail.com"
        )
        val contact7 = ContactData(
            "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8cHJvZmlsZSUyMHBpY3R1cmVzfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60",
            "Jonas",
            "0718953445",
            "jelefoff@gmail.com"
        )
        val contact8 = ContactData(
            "https://images.unsplash.com/photo-1605993439219-9d09d2020fa5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fHByb2ZpbGUlMjBwaWN0dXJlc3xlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60",
            "henriquetta",
            "0778153445",
            "henriquetta@gmail.com"
        )
        val contact9 = ContactData(
            "https://images.unsplash.com/photo-1544723795-3fb6469f5b39?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fHByb2ZpbGUlMjBwaWN0dXJlc3xlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60",
            "Gredi",
            "0711153445",
            "gredi@gmail.com"
        )

        val contactList = listOf(
            contact1,
            contact2,
            contact3,
            contact4,
            contact5,
            contact6,
            contact7,
            contact8,
            contact9
        )
        //Now you can instntite your dpter
        val ContactAdapter = ContactAdapter(contactList)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = ContactAdapter
        binding.btnAddContact

    }

}