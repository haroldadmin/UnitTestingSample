package com.kshitijchauhan.haroldadmin.unittests.base

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single {
        MoshiConverterFactory.create()
    }
    single {
        CoroutineCallAdapterFactory()
    }
    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .addConverterFactory(get<MoshiConverterFactory>())
            .addCallAdapterFactory(get<CoroutineCallAdapterFactory>())
            .baseUrl(API_URL)
            .build()
    }
}