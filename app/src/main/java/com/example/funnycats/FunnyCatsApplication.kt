package com.example.funnycats

import android.app.Application
import com.example.funnycats.data.network.NetworkDataSource
import com.example.funnycats.data.repository.CatsRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class FunnyCatsApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
       import(androidXModule(this@FunnyCatsApplication))

        bind() from singleton { NetworkDataSource() }
        bind<CatsRepository>() with singleton { CatsRepository(instance()) }
   }

}