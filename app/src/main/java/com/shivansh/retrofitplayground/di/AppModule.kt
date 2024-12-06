package com.shivansh.retrofitplayground.di

import com.shivansh.retrofitplayground.data.api.PostApi
import com.shivansh.retrofitplayground.data.repository.PostRepository
import com.shivansh.retrofitplayground.domain.repository.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.internal.SingleCheck
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPostApi(): PostApi {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
//            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(api: PostApi): PostRepository {
        return PostRepositoryImpl(api)
    }
}