package com.example.rates.ext

import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

fun ImageView.setIconResOrHide(iconRes: Int?) {
    if (iconRes == null) {
        isInvisible = true
        setImageDrawable(null)
    } else {
        isVisible = true
        setImageResource(iconRes)
    }
}