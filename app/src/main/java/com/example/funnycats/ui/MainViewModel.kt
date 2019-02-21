package com.example.funnycats.ui


import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.funnycats.data.network.NetworkDataSource
import com.example.funnycats.data.network.response.RandomCat
import com.example.funnycats.data.repository.CatsRepository
import io.reactivex.Single

class MainViewModel : ViewModel()
{
    private val catsRepository: CatsRepository = CatsRepository(NetworkDataSource())
    fun getRandomCat() : Single<RandomCat> = catsRepository.getRandomCat()

    companion object{
        fun create(activity: FragmentActivity): MainViewModel{
            var mainViewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)
            return mainViewModel
        }
    }
}