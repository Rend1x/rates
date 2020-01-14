package com.example.rates.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RatesResponse(
    @Json(name = "AUD")
    val aUDResponse: Double?,
    @Json(name = "BGN")
    val bGNResponse: Double?,
    @Json(name = "BRL")
    val bRLResponse: Double?,
    @Json(name = "CAD")
    val cADResponse: Double?,
    @Json(name = "CHF")
    val cHFResponse: Double?,
    @Json(name = "EUR")
    val eURResponse: Double?
)


