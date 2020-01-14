package com.example.rates.di

import android.app.Application
import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreModule::class]
)
interface CoreComponent {
    fun inject(app: Application)

    val context: Context
    val moshi: Moshi
    val retrofit: Retrofit
}