package com.example.rates.utils

import android.text.Editable
import android.text.TextWatcher

open class AbstractTextWatcher : TextWatcher {
    override fun afterTextChanged(text: Editable?) {
        // empty
    }

    override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {
        // empty
    }

    override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
        // empty
    }
}