package com.shivansh.retrofitplayground.domain.model

data class PostModel(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)