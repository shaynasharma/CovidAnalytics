package com.shayna.covidanalytics.ui

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.shayna.covidanalytics.R
import com.shayna.covidanalytics.ui.tabHandler.TabAdapter
import kotlinx.android.synthetic.main.fragment_main.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CovidAnalyticsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mTabAdapter: TabAdapter
    private var positionItem = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTabAdapter =
            TabAdapter(this, requireActivity())

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.e("tabselected pos", "${tab?.position}")
                pager.setCurrentItem(tab?.position!!, false)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.e("tabReselected pos", "${tab?.position}")
            }
        })


        pager.adapter = mTabAdapter
        setDividers()

        TabLayoutMediator(tab_layout, pager) { tab, position ->
            tab.text = getTabTitile(position, requireActivity())

            pager.setCurrentItem(tab.position, false)

        }.attach()

        pager.isUserInputEnabled = true

    }

    fun setDividers() {
        val root: View = tab_layout.getChildAt(0)
        if (root is LinearLayout) {
            root.showDividers = LinearLayout.SHOW_DIVIDER_NONE
            val drawable = GradientDrawable()
            drawable.setColor(resources.getColor(R.color.colorAccent))
            drawable.setSize(2, 1)
            root.dividerPadding = 5
            root.dividerDrawable = drawable
        }
    }

    private fun getTabTitile(position: Int, context: Context): String {

        var tabTitle = "3"
        if (position == 0) tabTitle = context.getString(R.string.tab_case_time_series)
        else if (position == 1) tabTitle = context.getString(R.string.tab_state_wise)
        else tabTitle = context.getString(R.string.tab_tested_wise)

        return tabTitle

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CovidAnalyticsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}