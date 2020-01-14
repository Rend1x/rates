package com.example.rates.data

import com.example.rates.base.BaseTransformer
import com.example.rates.domain.Rate
import javax.inject.Inject

class RatesResponseTransformer @Inject constructor() : BaseTransformer<RatesResponse, Rate> {
    override fun transform(data: RatesResponse) = Rate(
        data.aUDResponse,
        data.bGNResponse,
        data.bRLResponse,
        data.cADResponse,
        data.cHFResponse,
        data.eURResponse
    )
}