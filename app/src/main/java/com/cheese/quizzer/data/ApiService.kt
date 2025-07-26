package com.cheese.quizzer.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character/{id}")
    suspend fun getCharacter(@Path("id")id: Int) : Character
}