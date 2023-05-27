package com.henriette.contactsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.henriette.contactsapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        displayContact()
    }
    fun displayContact(){
        val contact1=ContactData("HE","Henriette","0791653445","henriette@gmail.com")
        val contact2=ContactData("HE","Henriette","0791653445","henriette@gmail.com")
        val contact3=ContactData("HE","Henriette","0791653445","henriette@gmail.com")
        val contact4=ContactData("HE","Henriette","0791653445","henriette@gmail.com")
        val contactList = listOf(contact1,contact2,contact3,contact4)
        val ContactAdapter=ContactAdapter(contactList)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=ContactAdapter
    }

}