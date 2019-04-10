package com.kshitijchauhan.haroldadmin.unittests.comments

import org.koin.core.context.loadKoinModules

object Comments {
    private val loadModules by lazy {
        loadKoinModules(commentsModule)
    }

    fun init() = loadModules
}
