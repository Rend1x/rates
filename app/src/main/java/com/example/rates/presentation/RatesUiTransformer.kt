package com.example.rates.presentation

import android.content.Context
import com.example.rates.R
import com.example.rates.base.BaseTransformer
import com.example.rates.domain.Rate
import javax.inject.Inject

class RatesUiTransformer @Inject constructor(
    private val context: Context
) : BaseTransformer<Rate, List<RateUi>> {
    override fun transform(data: Rate) =
        mutableListOf<RateUi>().apply {
            add(
                RateUi(
                    R.drawable.ic_eu,
                    context.getString(R.string.eur_name),
                    context.getString(R.string.eur_title),
                    data.eUR
                )
            )

            add(
                RateUi(
                    R.drawable.ic_eu,
                    context.getString(R.string.chf_name),
                    context.getString(R.string.chf_title),
                    data.cHF
                )
            )

            add(
                RateUi(
                    R.drawable.ic_eu,
                    context.getString(R.string.cad_name),
                    context.getString(R.string.cad_title),
                    data.cAD
                )
            )

            add(
                RateUi(
                    R.drawable.ic_eu,
                    context.getString(R.string.brl_name),
                    context.getString(R.string.brl_title),
                    data.bRL
                )
            )

            add(
                RateUi(
                    R.drawable.ic_eu,
                    context.getString(R.string.bgn_name),
                    context.getString(R.string.bgn_title),
                    data.bGN
                )
            )

            add(
                RateUi(
                    R.drawable.ic_eu,
                    context.getString(R.string.aud_name),
                    context.getString(R.string.aud_title),
                    data.aUD
                )
            )
        }
}
