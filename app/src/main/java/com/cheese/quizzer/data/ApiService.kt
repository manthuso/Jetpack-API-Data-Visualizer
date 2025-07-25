package com.cheese.quizzer.data

import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getCharacters(): CharacterApi
}