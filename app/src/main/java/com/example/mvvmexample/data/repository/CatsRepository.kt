package com.example.mvvmexample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmexample.data.db.AppDatabase
import com.example.mvvmexample.data.db.entity.Cat
import com.example.mvvmexample.data.network.MyApi
import com.example.mvvmexample.data.network.SafeApiRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatsRepository(
    private val api: MyApi,
    private val db: AppDatabase,
) : SafeApiRequest() {

    private val cats = MutableLiveData<List<Cat>>()

    init {
        cats.observeForever {
            saveQuotes(it)
        }
    }

    suspend fun getCats(): LiveData<List<Cat>> {
        return withContext(Dispatchers.IO) {
            fetchCats()
            db.getQuoteDao().getQuotes()
        }

    }

    private suspend fun fetchCats() {


        try {

            val response = apiRequest {
                api.getCats(10)
            }

            cats.postValue(response)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    private fun saveQuotes(quotes: List<Cat>) {
        CoroutineScope(Dispatchers.IO).launch {
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }

}