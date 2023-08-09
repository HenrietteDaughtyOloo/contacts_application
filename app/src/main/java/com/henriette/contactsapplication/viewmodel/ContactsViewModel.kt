package com.henriette.contactsapplication.viewmodel

import android.provider.ContactsContract.Contacts
import android.security.identity.AccessControlProfileId
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henriette.contactsapplication.model.Contact
import com.henriette.contactsapplication.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel: ViewModel() {
    val contactsRepo= ContactsRepository()

    fun saveContact(contact:Contact){
        viewModelScope.launch {
            contactsRepo.saveContact(contact)
        }
    }
    fun getContacts():LiveData<List<Contact>>{
        return contactsRepo.getAllContacts()
    }
    fun getContactsById(contactId: Int):LiveData<Contact>{
        return contactsRepo.getContactById(contactId)
    }


}