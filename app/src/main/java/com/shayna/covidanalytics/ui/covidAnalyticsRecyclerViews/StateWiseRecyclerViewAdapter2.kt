package com.shayna.covidanalytics.ui.covidAnalyticsRecyclerViews

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.shayna.covidanalytics.databinding.FragmentStateWiseItemBinding
import com.shayna.covidanalytics.db.entities.StateWise

class StateWiseRecyclerViewAdapter2(
    private val values: List<StateWise>
) : RecyclerView.Adapter<StateWiseRecyclerViewAdapter2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentStateWiseItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        Log.i("RecyclerView2","Item : "+item.active)
        holder.active.text = "item.active"
        holder.state.text = "item.state"
        holder.recovered.text = "item.recovered"
        holder.deaths.text = "item.deaths"
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentStateWiseItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val state: TextView = binding.state
        val active: TextView = binding.active
        val recovered: TextView = binding.recovered
        val deaths: TextView = binding.deaths

        override fun toString(): String {
            return super.toString() + ""
        }
    }

}