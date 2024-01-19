package com.example.mvvmexample.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.data.db.entity.Cat
import com.example.mvvmexample.data.repository.CatsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatsViewModel(

) : ViewModel() {


    lateinit var repository: CatsRepository


    constructor(repository: CatsRepository) : this() {
        this.repository = repository
    }


    suspend fun getCatsData(): LiveData<List<Cat>> {

    return  withContext(Dispatchers.IO){
        repository.getCats()

    }

    }


}
