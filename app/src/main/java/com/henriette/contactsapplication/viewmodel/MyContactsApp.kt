package com.henriette.contactsapplication.viewmodel

import android.app.Application
import android.content.Context

class MyContactsApp:Application() {
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

}