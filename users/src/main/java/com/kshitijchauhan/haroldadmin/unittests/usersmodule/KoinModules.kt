package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.service.users.UsersService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val usersModule = module {

        single { get<Retrofit>().create(UsersService::class.java) }
        single { UsersRepository(get<UsersService>()) }

        viewModel { UsersViewModel(get<UsersRepository>()) }

        factory { UsersDiffCallback() }
        factory { UsersAdapter(get<UsersDiffCallback>()) }
}