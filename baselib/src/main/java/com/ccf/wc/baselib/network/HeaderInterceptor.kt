package com.ccf.wc.baselib.network

import okhttp3.Interceptor
import okhttp3.Response

object HeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(
            request.newBuilder()
                .addHeader("c-phone-type", "Android")
                .addHeader("c-version", "1.0.0")
                .build()
        )
    }
}