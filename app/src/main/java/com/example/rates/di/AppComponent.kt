package com.example.rates.di

import com.example.rates.presentation.MainActivity
import com.example.rates.presentation.MainViewModel
import dagger.Component
import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@AppScope
@Component(
    modules = [AppModule::class], dependencies = [CoreComponent::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    val mainViewModel: MainViewModel
}