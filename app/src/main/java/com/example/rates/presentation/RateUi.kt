package com.example.rates.presentation

import androidx.annotation.DrawableRes

data class RateUi(
    @DrawableRes val image: Int,
    val title: String,
    val subTitle: String,
    val rate: Double?
)
