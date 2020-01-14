package com.example.rates.di

import com.example.rates.data.BaseServiceImpl
import com.example.rates.domain.BaseService
import com.example.rates.domain.LoadBaseUseCase
import com.example.rates.domain.LoadBaseUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [AppModule.BindsModule::class])
class AppModule {

    @Provides
    fun baseApi(retrofit: Retrofit): BaseServiceImpl.BaseApi = retrofit.create()

    @Module
    abstract inner class BindsModule {
        @Binds
        abstract fun loadBaseUseCase(arg: LoadBaseUseCaseImpl): LoadBaseUseCase

        @Binds
        abstract fun baseService(arg: BaseServiceImpl): BaseService
    }
}