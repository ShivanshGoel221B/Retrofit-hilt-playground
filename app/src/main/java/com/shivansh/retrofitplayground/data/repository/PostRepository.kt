package com.shivansh.retrofitplayground.data.repository

import com.shivansh.retrofitplayground.data.entity.PostEntity

interface PostRepository {
    suspend fun getAllPosts(): List<PostEntity>
}