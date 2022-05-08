package com.shayna.covidanalytics.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class StateWise(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @field:SerializedName("active") val active: String,
                @field:SerializedName("confirmed") val confirmed: String,
                @field:SerializedName("deaths") val deaths: String,
                @field:SerializedName("deltaconfirmed") val deltaconfirmed: String,
                @field:SerializedName("deltadeaths") val deltadeaths: String,
                @field:SerializedName("deltarecovered") val deltarecovered: String,
                @field:SerializedName("lastupdatedtime") val lastupdatedtime: String,
                @field:SerializedName("migratedother") val migratedother: String,
                @field:SerializedName("recovered") val recovered: String,
                @field:SerializedName("state") val state: String,
                @field:SerializedName("statecode") val statecode: String,
                @field:SerializedName("statenotes") val statenotes: String

                       ) {
}
