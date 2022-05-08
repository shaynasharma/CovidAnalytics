package com.shayna.covidanalytics

import android.app.Application
import android.content.Context
import com.shayna.covidanalytics.api.APICaller
import com.shayna.covidanalytics.api.MyApi
import com.shayna.covidanalytics.db.AppDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by Shayna Sharma on 06,May,2022
 */
internal class CovidAnalytics  : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@CovidAnalytics))
        bind() from singleton { MyApi() }
        bind() from singleton { APICaller(instance()) }
        bind() from singleton { AppDatabase(instance()) }
    }
}
