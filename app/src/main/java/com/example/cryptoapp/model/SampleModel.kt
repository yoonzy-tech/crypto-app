package com.example.cryptoapp.model

data class SampleModel(
    var name: String,
    var symbol: String,
    var price: Double,
    var changePercent: Double,
    var lineData: ArrayList<Int>,
    var propertyAmount: Double,
    var propertySize: Double
)
