package com.henriette.contactsapplication

//class ContactAdapter { var contactList: List<ContactData>:RecyclerView.Adapter<ContactViewHolder>(){
//
//}
////    var tweetList: List<TweetData>):RecyclerView.Adapter<TweetViewHolder>(){
//}

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.henriette.contactsapplication.databinding.ContactListItemBinding

class ContactRvAdapter(var contactList: List<ContactData>) :
    RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contactList.get(position)
        val binding = holder.binding
        binding.ivAvator.text = currentContact.avatar
        binding.tvNameDisplay.text = currentContact.dislayName
        binding.tvNum.text = currentContact.phoneNumber
        binding.tvEmail.text = currentContact.emailAddress
    }
