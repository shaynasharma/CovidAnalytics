package com.shayna.covidanalytics.ui.tabHandler

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shayna.covidanalytics.ui.covidAnalyticsTabsFragments.CaseTimeSeriesFragment
import com.shayna.covidanalytics.ui.covidAnalyticsTabsFragments.StateWiseFragment2
import com.shayna.covidanalytics.ui.covidAnalyticsTabsFragments.TestWiseFragment3

class TabAdapter(
    fragment: Fragment,
    requireActivity: FragmentActivity
) : FragmentStateAdapter(fragment) {
    private var mContext: FragmentActivity = requireActivity

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int) : Fragment {
        // Return a NEW fragment instance in createFragment(int)
        /* // val hours = Utills.getHours(position)*/
        var fragment:Fragment?=null
        when (position) {
            0 -> {
                fragment = CaseTimeSeriesFragment()
                Log.d("Tab","Tab 1");
            }
            1 -> {
                fragment = StateWiseFragment2()
                Log.d("Tab","Tab 2");
            }
            else -> {
                fragment = TestWiseFragment3()
                Log.d("Tab","Tab 3");
            }
        }
        Log.e("positions adapter", "$position")
        return fragment
    }
}