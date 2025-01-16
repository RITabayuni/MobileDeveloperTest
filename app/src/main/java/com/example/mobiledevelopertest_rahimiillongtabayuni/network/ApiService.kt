package com.example.mobiledevelopertest_rahimiillongtabayuni.network

import com.example.mobiledevelopertest_rahimiillongtabayuni.data.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UserResponse

}