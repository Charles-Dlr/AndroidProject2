package com.example.esiea3a_deliere

import android.app.Application
import android.content.Context

class MemeApplication : Application(){
    companion object{
         var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context =this
    }
}