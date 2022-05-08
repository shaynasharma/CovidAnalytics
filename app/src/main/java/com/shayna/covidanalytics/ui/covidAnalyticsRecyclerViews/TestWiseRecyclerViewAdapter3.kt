package com.shayna.covidanalytics.ui.covidAnalyticsRecyclerViews

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.shayna.covidanalytics.databinding.FragmentTestWiseItemBinding
import com.shayna.covidanalytics.db.entities.Tested

class TestWiseRecyclerViewAdapter3(
    private val values: List<Tested>
) : RecyclerView.Adapter<TestWiseRecyclerViewAdapter3.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentTestWiseItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        Log.i("RecyclerView3","Item : "+item.firstdoseadministered)
        holder.testedasof.text = "item.testedasof"
        holder.source.text = "item.source"
        holder.samplereportedtoday.text = "item.samplereportedtoday"
        holder.dailyrtpcrsamplescollectedicmrapplication.text = "item.dailyrtpcrsamplescollectedicmrapplication"
        holder.totaldosesadministered.text = "item.totaldosesadministered"
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentTestWiseItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val testedasof: TextView = binding.testedasof
        val dailyrtpcrsamplescollectedicmrapplication: TextView = binding.dailyrtpcrsamplescollectedicmrapplication
        val samplereportedtoday: TextView = binding.samplereportedtoday
        val totaldosesadministered: TextView = binding.totaldosesadministered
        val source: TextView = binding.source

        override fun toString(): String {
            return super.toString() + ""
        }
    }

}