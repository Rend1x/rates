package com.example.rates.domain

import io.reactivex.Observable

interface BaseService {
    fun getRate(base: String): Observable<Base>
}