package info.firozansari.espressoexamples.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import info.firozansari.espressoexamples.R
import info.firozansari.espressoexamples.adapters.PagerAdapter

class ViewPagerFragment : Fragment() {
    private var mRootView: View? = null
    private var mViewPager: ViewPager? = null
    private var mPagerAdapter: PagerAdapter? = null
    private lateinit var mTestData: Array<String>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.fragment_view_pager, container, false)
        setUpFragment()
        return mRootView
    }

    fun setUpFragment() {
        mTestData = arrayOf("Test One", "Test Two", "Test Three", "Test Four")
        mPagerAdapter = PagerAdapter(fragmentManager, mTestData)
        mViewPager = mRootView!!.findViewById<View>(R.id.pager) as ViewPager
        mViewPager!!.adapter = mPagerAdapter
    }

}