package com.github.waahoo.http

import com.github.waahoo.http.CookieMangement.cookieMgr
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE

const val userAgent =
  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36"

fun makeClient(logLevel: HttpLoggingInterceptor.Level = NONE) =
  OkHttpClient.Builder()
    .cookieJar(JavaNetCookieJar(cookieMgr))
    .addNetworkInterceptor { chain ->
      val req = chain.request()
      chain.proceed(
        req.newBuilder()
          .header("User-Agent", userAgent)
          .build()
      )
    }
    .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(logLevel))
    .build()