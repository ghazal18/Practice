package com.example.myapplication.ui

import com.example.myapplication.data.UserLocalDataSource
import com.example.myapplication.data.UserRemoteDataSource
import com.example.myapplication.data.UserRepository
import com.example.myapplication.network.ApiService
import com.example.myapplication.ui.UserViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
        val logger= HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
     //   val client = OkHttpClient.Builder().addInterceptor(logger).build()
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
        //    .client(client)
            .baseUrl("http://6086fa75a3b9c200173b758e.mockapi.io/api/v1/")
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