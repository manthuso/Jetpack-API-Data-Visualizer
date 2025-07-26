package com.cheese.quizzer.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)

