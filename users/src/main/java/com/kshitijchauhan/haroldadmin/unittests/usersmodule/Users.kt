package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import org.koin.core.context.loadKoinModules

object Users {
    private val loadModules by lazy {
        loadKoinModules(usersModule)
    }

    fun init() = loadModules
}