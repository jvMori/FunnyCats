package com.example.funnycats.data.network

import com.example.funnycats.data.network.response.RandomCatResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkDataSource{
    private val BASE_URL = "https://api.thecatapi.com/v1/"
    private var api: ApiCats

    init{
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        api =  retrofit.create(ApiCats::class.java)
    }

    fun getRandomCat() : Single<RandomCatResponse>{
        return api.getRandomCat()
    }
}