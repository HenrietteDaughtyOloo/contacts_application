package com.henriette.contactsapplication.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.henriette.contactsapplication.R
import com.henriette.contactsapplication.databinding.ContactListItemBinding
import com.henriette.contactsapplication.model.Contact
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import java.io.File

class ContactAdapter(var contactList: List<Contact>, var context: Context) :
    RecyclerView.Adapter<ContactViewHolder>() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact = contactList.get(position)
        var binding = holder.binding
        binding.tvDisplayName.text = currentContact.displayName
        binding.tvPhoneNumber.text = currentContact.phoneNumber
        binding.tvEmail.text = currentContact.emailAddress


        if (currentContact.avatar.isNotBlank()) {
            Picasso
                .get()
                .load(File(currentContact.avatar))
                .resize(80, 80)
//                .placeholder(R.drawable.boaz)
                .transform(CropCircleTransformation())
                .into(binding.ivAvatar)
        }



        binding.cvContact.setOnClickListener {
            val intent = Intent(context, ContactDetailsActivity::class.java)
            intent.putExtra("CONTACT_ID", currentContact.contactId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size

    }
}

class ContactViewHolder(var binding: ContactListItemBinding) : ViewHolder(binding.root)
