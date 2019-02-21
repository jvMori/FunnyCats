package com.example.funnycats.data.repository

import com.example.funnycats.data.network.NetworkDataSource
import com.example.funnycats.data.network.RandomCat
import com.example.funnycats.data.network.response.RandomCatResponse
import io.reactivex.Single

class CatsRepository(private val networkDataSource: NetworkDataSource) {

    fun getRandomCat() : Single<RandomCat>{
        return networkDataSource.getRandomCat()
            .map { cats : RandomCatResponse -> cats.response[0] }
    }
}