package com.shayna.covidanalytics.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shayna.covidanalytics.api.responses.CovidDataResponse
import com.shayna.covidanalytics.db.AppDatabase
import com.shayna.covidanalytics.db.entities.CasesTimeSeries
import com.shayna.covidanalytics.db.entities.StateWise
import com.shayna.covidanalytics.db.entities.Tested
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.net.HttpURLConnection

private val MINIMUM_INTERVAL = 6

class APICaller(
    private val db: AppDatabase
) {

    private val casesTimeSeries = MutableLiveData<List<CasesTimeSeries>>()
    private val statewise = MutableLiveData<List<StateWise>>()
    private val tested = MutableLiveData<List<Tested>>()



    init {
//        fetchCovidData()
        casesTimeSeries.observeForever {
            saveCaseTimeSeriesData(it)
        }
        statewise.observeForever {
            saveStateWiseData(it)
        }
        tested.observeForever {
            saveTestedData(it)
        }
    }

    suspend fun getCaseTimeSeries(): List<CasesTimeSeries> {
        return withContext(Dispatchers.IO) {
            fetchCovidData()
            db.getCovidAnalyticsDao().getCasesTimeSeries()
        }
    }

    suspend fun getStateWise(): List<StateWise> {
        return withContext(Dispatchers.IO) {
            fetchCovidData()
            db.getCovidAnalyticsDao().getStatewise()
        }
    }

    suspend fun getTested(): List<Tested> {
        return withContext(Dispatchers.IO) {
            fetchCovidData()
            db.getCovidAnalyticsDao().getTested()
        }
    }

    private fun fetchCovidData() {
        try {
            val apiService: ApiInterface = MyApi().getClient()!!.create(ApiInterface::class.java)
            val call: Call<CovidDataResponse> = apiService.getCovidData()!!
            call.enqueue(object : Callback<CovidDataResponse> {
                override fun onResponse(
                    call: Call<CovidDataResponse>,
                    response: Response<CovidDataResponse>
                ) {
                    val statusCode = response.code()
                    if (statusCode == HttpURLConnection.HTTP_OK) {
                        casesTimeSeries.postValue(response.body()!!.cases_time_series!!)
                        statewise.postValue(response.body()!!.statewise!!)
                        tested.postValue(response.body()!!.tested!!)
                        Log.d("Shayna", "doNetworkCall :: "+ db.getCovidAnalyticsDao().getCasesTimeSeries().get(0).date)
                    }
                }

                override fun onFailure(call: Call<CovidDataResponse>, t: Throwable) {
                    // Log error here since request failed
                    Log.e("Shayna", t.toString())
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun saveCaseTimeSeriesData(casesTimeSeries: List<CasesTimeSeries>) {
        Coroutines.io {
            db.getCovidAnalyticsDao().saveAllCasesTimeSeriesWise(casesTimeSeries)
        }
    }

    private fun saveStateWiseData(stateWise: List<StateWise>) {
        Coroutines.io {
            db.getCovidAnalyticsDao().saveAllStateWise(stateWise)
        }
    }

    private fun saveTestedData(tested: List<Tested>) {
        Coroutines.io {
            db.getCovidAnalyticsDao().saveAllTestWise(tested)
        }
    }


}