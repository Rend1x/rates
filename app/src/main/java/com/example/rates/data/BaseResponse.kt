package com.example.rates.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponse(
    @Json(name = "base")
    val base: String,
    @Json(name = "date")
    val data: String,
    @Json(name = "rates")
    val rates: RatesResponse
)