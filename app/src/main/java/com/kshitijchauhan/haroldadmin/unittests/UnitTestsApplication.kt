package com.kshitijchauhan.haroldadmin.unittests

import android.app.Application
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.networkModule
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.serviceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UnitTestsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@UnitTestsApplication)
            modules(
                networkModule,
                serviceModule
            )
        }
    }
}