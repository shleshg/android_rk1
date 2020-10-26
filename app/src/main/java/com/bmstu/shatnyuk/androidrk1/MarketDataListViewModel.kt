package com.bmstu.shatnyuk.androidrk1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bmstu.shatnyuk.androidrk1.model.MarketData
import kotlinx.coroutines.runBlocking

class MarketDataListViewModel : ViewModel() {

    private val marketDataList: MutableLiveData<List<MarketData>> by lazy {
        MutableLiveData<List<MarketData>>()
    }

    fun getMarketDataList(): LiveData<List<MarketData>> {
        return marketDataList
    }

    fun refreshMarketData(baseAsset: String, quoteAsset: String, numberOfDays: Int) {
        marketDataList.postValue(loadData(baseAsset, quoteAsset, numberOfDays))
    }

    private fun loadData(baseAsset: String, quoteAsset: String, numberOfDays: Int) =
        runBlocking<List<MarketData>> {
            loadMarketData(baseAsset, quoteAsset, numberOfDays)
        }
}