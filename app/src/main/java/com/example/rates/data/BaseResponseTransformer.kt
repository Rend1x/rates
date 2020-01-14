package com.example.rates.data

import com.example.rates.base.BaseTransformer
import com.example.rates.domain.Base
import javax.inject.Inject

class BaseResponseTransformer @Inject constructor(
    private val rateResponseTransformer: RatesResponseTransformer
) : BaseTransformer<BaseResponse, Base> {
    override fun transform(data: BaseResponse) =
        Base(
            data.base,
            data.data,
            rateResponseTransformer.transform(data.rates)
        )
}