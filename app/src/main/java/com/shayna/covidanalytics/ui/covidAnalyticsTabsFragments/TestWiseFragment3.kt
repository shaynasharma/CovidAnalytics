package com.shayna.covidanalytics.ui.covidAnalyticsTabsFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shayna.covidanalytics.R
import com.shayna.covidanalytics.api.APICaller
import com.shayna.covidanalytics.ui.covidAnalyticsRecyclerViews.TestWiseRecyclerViewAdapter3
import com.shayna.covidanalytics.utils.Coroutines
import com.shayna.covidanalytics.utils.lazyDeferred
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

/**
 * A fragment representing a list of Items.
 */
class TestWiseFragment3 : Fragment() , KodeinAware {

    override val kodein by kodein()

    private val apiCaller: APICaller by instance()

    private var columnCount = 1
    //private val apiCaller: APICaller by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tested_wise_item_list3, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }


                Coroutines.io {
                    adapter = TestWiseRecyclerViewAdapter3(testWiseData.await())
                }
            }
        }
        return view
    }

    private val testWiseData by lazyDeferred {
        apiCaller.getTested()
    }


    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            TestWiseFragment3().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}