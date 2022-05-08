package com.shayna.covidanalytics.api

import com.shayna.covidanalytics.api.responses.CovidDataResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("/data.json")
    fun getCovidData(): Call<CovidDataResponse>?
}
