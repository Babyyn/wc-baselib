package com.ccf.wc.baselib.network

import okhttp3.OkHttpClient

object HttpClients {

    private val baseHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(HeaderInterceptor)
        .addNetworkInterceptor(LogInterceptor)
        .build()

    fun newClient(operation: OkHttpClient.Builder.() -> Unit): OkHttpClient {
        return baseHttpClient.newBuilder()
            .apply(operation)
            .build()
    }
}