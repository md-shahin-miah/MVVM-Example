package com.example.mvvmexample.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmexample.data.db.entity.Cat


@Dao
interface CatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllQuotes(quotes: List<Cat>)

    @Query("SELECT * FROM Cat")
    fun getQuotes(): LiveData<List<Cat>>

}