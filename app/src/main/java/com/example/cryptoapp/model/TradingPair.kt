package com.example.cryptoapp.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class TradingPair(
    val id: String,
    @SerialName("base_currency")
    val baseCurrency: String,
    @SerialName("quote_currency")
    val quoteCurrency: String,
    @SerialName("quote_increment")
    val quoteIncrement: String,
    @SerialName("base_increment")
    val baseIncrement: String,
    @SerialName("display_name")
    val displayName: String,
    @SerialName("min_market_funds")
    val minMarketFunds: String,
    @SerialName("margin_enabled")
    val marginEnabled: Boolean,
    @SerialName("post_only")
    val postOnly: Boolean,
    @SerialName("limit_only")
    val limitOnly: Boolean,
    @SerialName("cancel_only")
    val cancelOnly: Boolean,
    val status: String,
    @SerialName("status_message")
    val statusMessage: String,
    @SerialName("trading_disabled")
    val tradingDisabled: Boolean,
    @SerialName("fx_stablecoin")
    val fxStablecoin: Boolean,
    @SerialName("max_slipping_percentage")
    val maxSlippagePercentage: String,
    @SerialName("auction_mode")
    val auctionMode: Boolean,
    @SerialName("high_bid_limit_currency")
    val highBidLimitPercentage: String
)
