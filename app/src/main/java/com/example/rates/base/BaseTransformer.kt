package com.example.rates.base

interface BaseTransformer<T, R> {
    fun transform(data: T): R
}