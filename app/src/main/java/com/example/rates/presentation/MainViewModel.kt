package com.example.rates.presentation

import androidx.lifecycle.MutableLiveData
import com.example.rates.base.BaseViewModel
import com.example.rates.domain.LoadBaseUseCase
import com.example.rates.ext.nonNullValue
import com.example.rates.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val loadBaseUseCase: LoadBaseUseCase,
    private val ratesUiTransformer: RatesUiTransformer
) : BaseViewModel() {

    companion object {
        const val DEFAULT_COUNTRY = "EUR"
        const val DELAY: Long = 1
        const val POSITION_FIRST = 0
        const val NULL = "0"
    }

    val state = MutableLiveData<State>()
    val errorState = SingleLiveEvent<String>()

    fun init() {
        loadBaseUseCase.getBase(DEFAULT_COUNTRY)
            .repeatWhen {
                it.delay(DELAY, TimeUnit.SECONDS)
            }
            .map { ratesUiTransformer.transform(it.rates) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    state.value = State(it)
                },
                {
                    Timber.e(it)
                    errorState.value = it.message
                }
            ).addDisposable()
    }

    fun loadBase(rateUi: RateUi, pos: Int) {

        onCleared()

        loadBaseUseCase.getBase(rateUi.title)
            .repeatWhen {
                it.delay(DELAY, TimeUnit.SECONDS)
            }
            .map { ratesUiTransformer.transform(it.rates) }
            .map { rateMap ->
                Collections.swap(rateMap, POSITION_FIRST, pos)
                rateMap
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    state.value = state.nonNullValue.copy(rates = it)
                },
                {
                    Timber.e(it)
                    errorState.value = it.message
                }
            ).addDisposable()
    }

    fun updateRate(count: String) {
        val factory = checkNull(count).toDouble()
        state.value = state.nonNullValue.copy(factory = factory)
    }

    private fun checkNull(str: String): String {
        return if (str.isEmpty() || str == "null")
            NULL
        else
            str
    }

    data class State(
        val rates: List<RateUi>,
        val factory: Double? = null
    )
}