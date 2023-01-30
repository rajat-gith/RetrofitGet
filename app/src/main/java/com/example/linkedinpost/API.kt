package com.example.linkedinpost

import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("/todos")
    suspend fun getTodos(): Response<List<ToDo>>
}