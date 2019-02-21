package com.example.funnycats.ui


import androidx.lifecycle.ViewModel
import com.example.funnycats.data.network.NetworkDataSource
import com.example.funnycats.data.network.RandomCat
import com.example.funnycats.data.repository.CatsRepository
import io.reactivex.Single

class MainViewModel : ViewModel()
{
    private val catsRepository: CatsRepository = CatsRepository(NetworkDataSource())
    fun getRandomCat() : Single<RandomCat> = catsRepository.getRandomCat().map { cat -> cat.response[0] }
}