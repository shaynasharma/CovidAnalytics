package com.shayna.covidanalytics.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shayna.covidanalytics.db.entities.CasesTimeSeries
import com.shayna.covidanalytics.db.entities.StateWise
import com.shayna.covidanalytics.db.entities.Tested

/**
 * Created by Shayna Sharma on 12,June,2020
 */
@Dao
interface CovidAnalyticsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllCasesTimeSeriesWise(casesTimeSeries : List<CasesTimeSeries>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllStateWise(casesTimeSeries : List<StateWise>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllTestWise(casesTimeSeries : List<Tested>)

    @Query("SELECT * FROM CasesTimeSeries")
    fun getCasesTimeSeries() : List<CasesTimeSeries>

    @Query("SELECT * FROM StateWise")
    fun getStatewise() : List<StateWise>

    @Query("SELECT * FROM Tested")
    fun getTested() : List<Tested>

}