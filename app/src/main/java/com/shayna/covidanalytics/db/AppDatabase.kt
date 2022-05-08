package com.shayna.covidanalytics.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shayna.covidanalytics.db.entities.CasesTimeSeries
import com.shayna.covidanalytics.db.entities.StateWise
import com.shayna.covidanalytics.db.entities.Tested

/**
 * Created by Shayna Sharma on 12,June,2020
 */
@Database(
    entities = [CasesTimeSeries::class,StateWise::class,Tested::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCovidAnalyticsDao(): CovidAnalyticsDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }
}