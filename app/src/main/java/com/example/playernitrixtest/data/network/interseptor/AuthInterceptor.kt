package com.example.playernitrixtest.data.network.interseptor

import com.example.playernitrixtest.utils.Constants.HEADER_KEY
import com.example.playernitrixtest.utils.Constants.HEADER_VALUE
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
            .url(originalRequest.url)
            .addHeader(HEADER_KEY, HEADER_VALUE)
            .build()

        return chain.proceed(newRequest)
    }
}