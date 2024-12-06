package com.shivansh.retrofitplayground.domain.repository

import com.shivansh.retrofitplayground.data.api.PostApi
import com.shivansh.retrofitplayground.data.entity.PostEntity
import com.shivansh.retrofitplayground.data.repository.PostRepository
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import javax.inject.Inject

class PostRepositoryImpl (
    private val api: PostApi
): PostRepository {

    override suspend fun getAllPosts(): List<PostEntity> {
        return api.getPosts("Some Header").body()?: emptyList()
    }
}

class CustomConverterFactory: Converter.Factory() {
    override fun stringConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, String>? {
        return super.stringConverter(type, annotations, retrofit)
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<out Annotation>,
        methodAnnotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        return super.responseBodyConverter(type, annotations, retrofit)
    }
}