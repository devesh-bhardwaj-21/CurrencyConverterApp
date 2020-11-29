package com.devesh.currencyconverterapp.di

import androidx.viewbinding.BuildConfig
import com.devesh.currencyconverterapp.data.api.ApiService
import com.devesh.currencyconverterapp.utils.AppConstants
import com.devesh.currencyconverterapp.utils.baseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object ApiModule {

    @Provides
    @Singleton
    fun apiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl.toString()).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logger())
            .connectTimeout(AppConstants.timeoutConnect.toLong(), TimeUnit.SECONDS)
            .readTimeout(AppConstants.timeoutRead.toLong(), TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun logger(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS).level =
                HttpLoggingInterceptor.Level.BODY
        }
        return loggingInterceptor
    }
}
