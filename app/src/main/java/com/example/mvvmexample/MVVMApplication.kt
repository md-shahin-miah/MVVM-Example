package com.example.mvvmexample

import android.app.Application
import com.example.mvvmexample.data.db.AppDatabase

class MVVMApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        AppDatabase.getInstance(this)

    }


}