package info.firozansari.espressoexamples.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import info.firozansari.espressoexamples.fragments.PagerFragment

class PagerAdapter : FragmentStatePagerAdapter {
    lateinit var mStrings: Array<String>

    constructor(fm: FragmentManager?) : super(fm!!) {}
    constructor(fm: FragmentManager?, strings: Array<String>) : super(fm!!) {
        mStrings = strings
    }

    override fun getItem(position: Int): Fragment {
        return PagerFragment.newInstance(mStrings[position])
    }

    override fun getCount(): Int {
        return mStrings.size
    }
}