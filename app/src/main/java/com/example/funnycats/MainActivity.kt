package com.example.funnycats

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.funnycats.ui.MainViewModel
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {

    private val compositeDisposableOnPause = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = MainViewModel.create(this)
        mainViewModel.getRandomCat().doOnSubscribe {
            compositeDisposableOnPause.add(it)
        }.observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                result?.let {
                    Picasso.get().load(it.url).into(catImageView)
                }
            }

    }

    override fun onPause() {
        compositeDisposableOnPause.clear()
        super.onPause()
    }
}
