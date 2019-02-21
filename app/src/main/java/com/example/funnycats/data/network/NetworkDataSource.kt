package com.example.funnycats.data.network

import com.example.funnycats.data.network.response.RandomCat
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkDataSource{
    private val BASE_URL = "https://api.thecatapi.com/v1/"
    private var api: ApiCats
    private val apiKeyHeader: String = "x-api-key"
    private val apiKey = "cdadbfec-8517-4f52-bac7-f17b62fd1b35"

    init{
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader(apiKeyHeader, apiKey)
                .build()
            chain.proceed(request)
        }.build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        api =  retrofit.create(ApiCats::class.java)
    }

    fun getRandomCat() : Single<List<RandomCat>>{
        return api.getRandomCat()
    }
}