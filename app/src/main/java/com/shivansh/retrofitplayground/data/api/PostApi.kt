package com.shivansh.retrofitplayground.data.api

import com.shivansh.retrofitplayground.data.entity.PostEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface PostApi {
    @GET("/posts")
    suspend fun getPosts(@Header("authorization") customHeader: String): Response<List<PostEntity>>
}