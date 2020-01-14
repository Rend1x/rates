package com.example.rates

import androidx.multidex.MultiDexApplication
import com.example.rates.di.AppInjector
import com.example.rates.di.CoreModule
import com.example.rates.di.DaggerAppComponent
import com.example.rates.di.DaggerCoreComponent
import timber.log.Timber

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
        initTimber()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initDagger() {

        val coreComponent = DaggerCoreComponent.builder()
            .coreModule(CoreModule(this))
            .build()

        coreComponent.inject(this)

        val appComponent = DaggerAppComponent.builder()
            .coreComponent(coreComponent)
            .build()

        AppInjector.coreComponent = coreComponent
        AppInjector.appComponent = appComponent
    }
}