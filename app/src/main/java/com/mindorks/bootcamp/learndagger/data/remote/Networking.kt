package com.mindorks.bootcamp.learndagger.data.remote

import com.mindorks.bootcamp.learndagger.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Ajay Deepak on 17-06-2019.
 *
 * Provides retrofit instance with configuration
 */

object Networking {

    const val  HEADER_API_KEY = "x-api-key"

    // we would get these values we are accessing any public api's

    const val  HEADER_ACCESS_TOKEN = "x-access-token"
    const val  HEADER_USER_ID = "x-user-id"


    private val NETWORK_CALL_TIMEOUT = 60
    lateinit var API_KEY: String

    fun create(apiKey: String, baseUrl: String, cacheDir: File, cacheSize: Long ): NetworkService{

       API_KEY = apiKey
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client( OkHttpClient.Builder()
                        .cache(Cache(cacheDir, cacheSize))
                        .addInterceptor(HttpLoggingInterceptor()
                                .apply {
                                    level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                                    else HttpLoggingInterceptor.Level.NONE
                                })
                        .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                        .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .build()
                ).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(NetworkService::class.java)


    }
}