package com.example.marsphotos.network

import com.example.cryptoapp.model.TradingPair
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

/**
 * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

/**
 * Retrofit service object for creating api calls
 */
interface CoinbaseApiService {
    @GET("products")
    suspend fun getTradingPairs(): List<TradingPair>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object CoinbaseApi {
    val retrofitService: CoinbaseApiService by lazy {
        retrofit.create(CoinbaseApiService::class.java)
    }
}