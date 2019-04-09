package com.kshitijchauhan.haroldadmin.unittests.posts

import org.koin.core.context.loadKoinModules

object Posts {
    private val loadModules by lazy {
        loadKoinModules(postsModule)
    }

    fun init() = loadModules
}