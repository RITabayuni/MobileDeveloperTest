package com.example.mobiledevelopertest_rahimiillongtabayuni.data

data class UserResponse(
    val data: List<User>,
    val page: Int,
    val total_pages: Int
)

data class User(
    val id: Int,
    val first_name: String,
    val last_name: String,
    val email: String,
    val avatar: String
)
