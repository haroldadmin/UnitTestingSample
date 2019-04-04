package com.kshitijchauhan.haroldadmin.json_placeholder_repository

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.posts.PostsService
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.users.UsersService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
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
        RxJava2CallAdapterFactory.create()
    }
    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .addConverterFactory(get<MoshiConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .baseUrl(API_URL)
            .build()
    }
}

val serviceModule = module {
    single {
        get<Retrofit>().create(UsersService::class.java)
    }
    single {
        get<Retrofit>().create(PostsService::class.java)
    }
}