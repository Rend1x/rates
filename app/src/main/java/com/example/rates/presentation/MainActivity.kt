package com.example.rates.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rates.R
import com.example.rates.di.AppInjector
import com.example.rates.ext.createViewModel
import com.example.rates.ext.observeValue
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel by lazy {
        createViewModel { AppInjector.appComponent.mainViewModel }
    }

    private val mainAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppInjector.appComponent.inject(this)
        initRv()

        viewModel.init()

        viewModel.state.observeValue(this) {
            populateAdapter(it.rates, it.factory)
        }

        viewModel.errorState.observeValue(this) {
            mainError.isVisible = true
            mainRv.isVisible = false
            mainError.text = it
        }
    }

    private fun populateAdapter(
        rates: List<RateUi>,
        factory: Double?
    ) {
        with(mainAdapter) {
            clear()
            addAll(rates.map { rateUi ->
                RateItem(
                    rateUi,
                    factory,
                    { rate, pos -> viewModel.loadBase(rate, pos) },
                    { viewModel.updateRate(it) }
                )
            })
        }
    }

    private fun initRv() = with(mainRv) {
        layoutManager = LinearLayoutManager(context)
        adapter = mainAdapter
    }

}
