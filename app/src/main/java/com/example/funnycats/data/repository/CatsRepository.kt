package com.example.funnycats.data.repository

import com.example.funnycats.data.network.NetworkDataSource
import com.example.funnycats.data.network.response.RandomCat
import io.reactivex.Single

class CatsRepository(private val networkDataSource: NetworkDataSource) {

    fun getRandomCat() : Single<RandomCat>{
        return networkDataSource.getRandomCat()
            .map { cats : List<RandomCat> -> cats[0] }
    }
}