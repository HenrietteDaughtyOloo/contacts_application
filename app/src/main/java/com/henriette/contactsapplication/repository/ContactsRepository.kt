package com.henriette.contactsapplication.repository

import androidx.lifecycle.LiveData
import com.henriette.contactsapplication.viewmodel.MyContactsApp
import com.henriette.contactsapplication.database.ContactsDb
import com.henriette.contactsapplication.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDb.getDatabase(MyContactsApp.appContext)

   suspend fun saveContact(contacts:Contact){
        withContext(Dispatchers.IO){
            database.getContactDao().insertContact(contacts)
        }
    }

  fun getAllContacts(): LiveData<List<Contact>>{
        return database.getContactDao().getAllContact()
    }
    fun getContactById(contactId: Int):LiveData<Contact>{
        return  database.getContactDao().getContactId(contactId)
    }
}