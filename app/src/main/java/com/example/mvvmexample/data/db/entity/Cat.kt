package com.example.mvvmexample.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cat(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val url: String,
    val width: Long,
    val height: Long,
)