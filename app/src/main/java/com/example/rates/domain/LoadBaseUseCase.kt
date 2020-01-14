package com.example.rates.domain

import io.reactivex.Observable
import javax.inject.Inject

interface LoadBaseUseCase {
    fun getBase(base: String): Observable<Base>
}

class LoadBaseUseCaseImpl @Inject constructor(
    private val baseService: BaseService
) : LoadBaseUseCase {
    override fun getBase(base: String): Observable<Base> =
        baseService.getRate(base)
}