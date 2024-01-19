package com.example.mvvmexample.data.network.response

import com.example.mvvmexample.data.db.entity.Cat

typealias Cat = List<Cat>;

data class QuotesResponse(
    val cats: List<Cat>
)