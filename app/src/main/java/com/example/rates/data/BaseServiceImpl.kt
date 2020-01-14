package com.example.rates.data

import com.example.rates.domain.Base
import com.example.rates.domain.BaseService
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class BaseServiceImpl @Inject constructor(
    private val baseApi: BaseApi,
    private val baseResponseTransformer: BaseResponseTransformer
) : BaseService {

    override fun getRate(base: String): Observable<Base> =
        baseApi.getBaseRate(base)
            .map { baseResponseTransformer.transform(it) }

    interface BaseApi {
        @GET("latest")
        fun getBaseRate(
            @Query("base") base: String
        ): Observable<BaseResponse>
    }
}