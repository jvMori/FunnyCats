package com.example.funnycats.ui.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.funnycats.R
import com.example.funnycats.data.network.response.RandomCat
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {

    private val compositeDisposableOnPause = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel = MainViewModel.create(this)
        getRandomCat(mainViewModel)
        randomBtn.setOnClickListener {
            getRandomCat(mainViewModel)
        }
    }

    @SuppressLint("CheckResult")
    fun getRandomCat(mainViewModel : MainViewModel) {
        mainViewModel.getRandomCat().doOnSubscribe {
            compositeDisposableOnPause.add(it)
        }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .onErrorReturn { RandomCat(listOf(), null, null) }
            .subscribe { result ->
                result?.url.let {
                    Picasso.get().load(it).into(catImageView)
                }
            }
    }

    override fun onPause() {
        compositeDisposableOnPause.clear()
        super.onPause()
    }
}
