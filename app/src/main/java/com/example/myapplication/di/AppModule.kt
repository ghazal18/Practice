package com.example.myapplication.di

import com.example.myapplication.data.UserLocalDataSource
import com.example.myapplication.data.UserRemoteDataSource
import com.example.myapplication.data.UserRepository
import com.example.myapplication.network.ApiService
import com.example.myapplication.ui.UserViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val AppModule = module {
    single {
        val retrofit = get() as Retrofit
        val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
        retrofitService
    }
    single {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.themoviedb.org/3/")
            .build()
        retrofit
    }
    single {
        UserRepository(get(), get())
    }
    single {
        UserLocalDataSource()
    }
    single {
        UserRemoteDataSource(get())
    }
    viewModel { UserViewModel(get()) }
}