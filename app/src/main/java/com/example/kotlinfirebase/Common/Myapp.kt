package com.example.kotlinfirebase.Common

import android.app.Application

class Myapp:Application() {



    companion object{
        lateinit var instance:Myapp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}