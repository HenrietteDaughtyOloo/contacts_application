package com.henriette.contactsapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.henriette.contactsapplication.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactAdapter (var ContactList:List<ContactData>):RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact=ContactList.get(position)
        var binding = holder.binding
//        binding.ivAvatar.text=currentContact.avatar
        binding.tvDisplayName.text=currentContact.dislayName
        binding.tvPhoneNumber.text=currentContact.phoneNumber
        binding.tvEmail.text=currentContact.emailAddress

        Picasso
            .get()
            .load(currentContact.avatar)
            .placeholder(R.drawable.boaz)
//            .resize(80,80)
//            .centerCrop()
            .transform(/* transformation = */ CropCircleTransformation())
//            .transform(CropCircleTransformation())
            .into(binding.ivAvatar)
    }

    override fun getItemCount(): Int {
        return ContactList.size

    }
}
class ContactViewHolder(var binding: ContactListItemBinding):ViewHolder(binding.root)
