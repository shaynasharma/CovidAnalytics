package com.shayna.covidanalytics.api.responses

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.shayna.covidanalytics.db.entities.CasesTimeSeries
import com.shayna.covidanalytics.db.entities.StateWise
import com.shayna.covidanalytics.db.entities.Tested
import java.util.*

data class CovidDataResponse(
    val cases_time_series:List<CasesTimeSeries>?,
    val statewise:List<StateWise>?,
    val tested:List<Tested>?){
}
