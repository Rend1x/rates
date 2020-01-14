package com.example.rates.ext

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions

fun RequestBuilder<Drawable>.withCenterCropOval() = apply(
    RequestOptions().circleCrop()
)