package com.henriette.contactsapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var contactId: Int,
    var avatar: String,
    var dislayName: String,
    var phoneNumber: String,
    val emailAddress: String,
)
