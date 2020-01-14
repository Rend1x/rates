package com.example.rates.presentation

import android.text.Editable
import com.bumptech.glide.Glide
import com.example.rates.R
import com.example.rates.utils.AbstractTextWatcher
import com.example.rates.ext.withCenterCropOval
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_rate.view.*

class RateItem(
    private val rateUi: RateUi,
    private val factory: Double?,
    private val clickListener: ((RateUi, Int) -> Unit),
    private val editTextListener: ((String) -> Unit)
) : Item() {

    override fun getLayout() = R.layout.item_rate

    override fun bind(viewHolder: GroupieViewHolder, position: Int) = with(viewHolder.itemView) {
        with(rateUi) {

            Glide.with(itemCurrency)
                .load(image)
                .withCenterCropOval()
                .into(itemCurrency)

            itemTypeName.text = title
            itemName.text = subTitle

            with(itemInput) {
                if (position != 0) {
                    if (factory == null) {
                        setText(rate.toString())
                    } else {
                        setText(rate?.times(factory).toString())
                    }
                } else {
                    addTextChangedListener(object : AbstractTextWatcher() {
                        override fun afterTextChanged(text: Editable?) {
                            editTextListener(text.toString())
                        }
                    })
                }
            }
        }

        setOnClickListener {
            clickListener(rateUi, position)
        }
    }
}