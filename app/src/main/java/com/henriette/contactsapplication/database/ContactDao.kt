package com.henriette.contactsapplication.database

import android.security.identity.AccessControlProfileId
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.henriette.contactsapplication.model.Contact

@Dao

interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM Contacts ORDER BY displayName")
    fun getAllContact(): LiveData<List<Contact>>

    @Query("SELECT*FROM Contacts WHERE contactId= :contactId")
    fun getContactId(contactId: Int): LiveData<Contact>

}