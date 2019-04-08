package com.kshitijchauhan.haroldadmin.unittests

import android.app.Application
import com.kshitijchauhan.haroldadmin.unittests.base.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class UnitTestsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(this@UnitTestsApplication)
            modules(networkModule)
            logger(AndroidLogger())
        }
    }
}