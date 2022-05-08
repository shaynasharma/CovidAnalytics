package com.shayna.covidanalytics.ui.covidAnalyticsRecyclerViews

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.shayna.covidanalytics.databinding.FragmentCaseWiseItemBinding
import com.shayna.covidanalytics.db.entities.CasesTimeSeries

class CaseTimeSeriesWiseRecyclerViewAdapter(
    private val values: List<CasesTimeSeries>
) : RecyclerView.Adapter<CaseTimeSeriesWiseRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCaseWiseItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        Log.i("RecyclerView","Item : "+item.dailyrecovered)
        holder.date.text = "item.date"
        holder.totalconfirmed.text = "item.totalconfirmed"
        holder.totaldeceased.text = "item.totaldeceased"
        holder.totalrecovered.text = "item.totalrecovered"
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentCaseWiseItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val date: TextView = binding.date
        val totalconfirmed: TextView = binding.totalconfirmed

        val totaldeceased: TextView = binding.totaldeceased

        val totalrecovered: TextView = binding.totalrecovered

        override fun toString(): String {
            return super.toString() + ""
        }
    }

}