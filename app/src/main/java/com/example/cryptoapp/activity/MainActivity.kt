package com.example.cryptoapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.adapter.CryptoAdapter
import com.example.cryptoapp.adapter.StockAdapter
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.model.SampleModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val lineData = arrayListOf(1000, 1100, 1200, 1100)
    private val lineData2 = arrayListOf(2100, 2000, 1900, 2000)
    private val lineData3 = arrayListOf(900, 1100, 1000, 1150)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cryptoList()
        stockList()
    }

    private fun stockList() {
        LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        ).also { this.binding.cryptoView.layoutManager = it }

        val domainArrayList = arrayListOf(
            SampleModel("NASDAQ100", "BTX", 1234.12, 2.13, lineData, 1234.12, 0.123),
            SampleModel("S&P 500", "ETH", 2134.12, -1.13, lineData2, 6545.12, 0.123),
            SampleModel("Dow Jones", "ROX", 4324.12, 0.72, lineData3, 1234.12, 0.123)
        )

        binding.stockView.adapter = StockAdapter(domainArrayList)
    }

    private fun cryptoList() {
        LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        ).also { this.binding.stockView.layoutManager = it }

        val domainArrayList = arrayListOf(
            SampleModel("bitcoin", "BTX", 1234.12, 2.13, lineData, 1234.12, 0.123),
            SampleModel("etherium", "ETH", 2134.12, -1.13, lineData2, 6545.12, 0.123),
            SampleModel("trox", "ROX", 4324.12, 0.72, lineData3, 1234.12, 0.123)
        )

        binding.cryptoView.adapter = CryptoAdapter(domainArrayList)
    }
}

