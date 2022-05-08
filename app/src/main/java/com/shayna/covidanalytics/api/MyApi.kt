package com.shayna.covidanalytics.api

import com.shayna.covidanalytics.api.responses.CovidDataResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class  MyApi {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://data.covid19india.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

}