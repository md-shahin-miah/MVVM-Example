package com.example.mvvmexample

import CatsViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mvvmexample.data.db.AppDatabase
import com.example.mvvmexample.data.network.MyApi
import com.example.mvvmexample.data.network.NetworkConnectionInterceptor
import com.example.mvvmexample.data.repository.CatsRepository
import com.example.mvvmexample.view.CatsViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
        val api = MyApi(networkConnectionInterceptor)
        val db = AppDatabase.getInstance(this)
        val repository = CatsRepository(api = api, db = db)

        val viewModel =
            ViewModelProvider(this, CatsViewModelFactory(repository))[CatsViewModel::class.java]


        lifecycleScope.launch {

            viewModel.getCatsData()

        }


    }
}