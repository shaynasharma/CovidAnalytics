package com.shayna.covidanalytics.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class Tested(

    @PrimaryKey(autoGenerate = true)
    val id : Int,
@field:SerializedName("dailyrtpcrsamplescollectedicmrapplication")val dailyrtpcrsamplescollectedicmrapplication: String,
@field:SerializedName("firstdoseadministered")val firstdoseadministered: String,
@field:SerializedName("frontlineworkersvaccinated1stdose")val frontlineworkersvaccinated1stdose: String,
@field:SerializedName("frontlineworkersvaccinated2nddose")val frontlineworkersvaccinated2nddose: String,
@field:SerializedName("healthcareworkersvaccinated1stdose")val healthcareworkersvaccinated1stdose: String,
@field:SerializedName("healthcareworkersvaccinated2nddose")val healthcareworkersvaccinated2nddose: String,
@field:SerializedName("over45years1stdose")val over45years1stdose: String,
@field:SerializedName("over45years2nddose")val over45years2nddose: String,
@field:SerializedName("over60years1stdose")val over60years1stdose: String,
@field:SerializedName("over60years2nddose")val over60years2nddose: String,
@field:SerializedName("positivecasesfromsamplesreported")val positivecasesfromsamplesreported: String,
@field:SerializedName("registration18-45years")val registration18_45years: String,
@field:SerializedName("registrationabove45years")val registrationabove45years: String,
@field:SerializedName("registrationflwhcw")val registrationflwhcw: String,
@field:SerializedName("registrationonline")val registrationonline: String,
@field:SerializedName("registrationonspot")val registrationonspot: String,
@field:SerializedName("samplereportedtoday")val samplereportedtoday: String,
@field:SerializedName("seconddoseadministered")val seconddoseadministered: String,
@field:SerializedName("source")val source: String,
@field:SerializedName("source2")val source2: String,
@field:SerializedName("source3")val source3: String,
@field:SerializedName("source4")val source4: String,
@field:SerializedName("testedasof")val testedasof: String,
@field:SerializedName("testsconductedbyprivatelabs")val testsconductedbyprivatelabs: String,
@field:SerializedName("to60yearswithco-morbidities1stdose")val to60yearswithco_morbidities1stdose: String ,

@field:SerializedName("totaldosesadministered")val totaldosesadministered: String,
@field:SerializedName("totaldosesavailablewithstates")val totaldosesavailablewithstates: String,
@field:SerializedName("totaldosesavailablewithstatesprivatehospitals")val totaldosesavailablewithstatesprivatehospitals: String,
@field:SerializedName("totaldosesinpipeline")val totaldosesinpipeline: String,
@field:SerializedName("totaldosesprovidedtostatesuts")val totaldosesprovidedtostatesuts: String,
@field:SerializedName("totalindividualsregistered")val totalindividualsregistered: String,
@field:SerializedName("totalindividualstested")val totalindividualstested: String,
@field:SerializedName("totalpositivecases")val totalpositivecases: String,

@field:SerializedName("totalrtpcrsamplescollectedicmrapplication")val totalrtpcrsamplescollectedicmrapplication: String,
@field:SerializedName("totalsamplestested")val totalsamplestested: String,
@field:SerializedName("totalsessionsconducted")val totalsessionsconducted: String,
@field:SerializedName("totalvaccineconsumptionincludingwastage")val totalvaccineconsumptionincludingwastage: String,
@field:SerializedName("updatetimestamp")val updatetimestamp: String,
@field:SerializedName("years1stdose")val years1stdose: String,
@field:SerializedName("years2nddose")val years2nddose: String,
) {
}
