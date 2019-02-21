package com.example.funnycats.data.network

import com.example.funnycats.data.network.response.RandomCat
import io.reactivex.Single
import retrofit2.http.GET

//https://api.thecatapi.com/v1/images/search
interface ApiCats
{
    @GET("images/search")
    fun getRandomCat() : Single<List<RandomCat>>

}