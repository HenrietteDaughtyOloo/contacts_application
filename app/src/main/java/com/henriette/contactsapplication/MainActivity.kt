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
        val contact1=ContactData("HE","Barachicho Mee","0791653445","brchicho@gmail.com")
        val contact2=ContactData("@drawable/barachicha","Trcy ","0706553445","trcy@gmail.com")
        val contact3=ContactData("HE","Jefferey Jmes","0711153445","jeff@gmail.com")
        val contact4=ContactData("HE","Lucy Monic","0734553445","monic@gmail.com")
        val contact5=ContactData("HE","Boaz","07890153445","boaz@gmail.com")
        val contact6=ContactData("HE","Maina King'ang'i","0711153445","droid@gmail.com")
        val contact7=ContactData("HE","Jonas","0718953445","jelefoff@gmail.com")
        val contact8=ContactData("HE","henriquetta","0778153445","henriquetta@gmail.com")
        val contact9=ContactData("HE","Gredi","0711153445","gredi@gmail.com")

        val contactList = listOf(contact1,contact2,contact3,contact4,contact5,contact6,contact7,contact8,contact9)
        val ContactAdapter=ContactAdapter(contactList)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=ContactAdapter
    }

}