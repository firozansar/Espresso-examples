package info.firozansari.espressoexamples.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import info.firozansari.espressoexamples.R

class HierarchyFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hierarchy, container, false)
    }

    companion object {
        fun newInstance(): HierarchyFragment {
            val fragment = HierarchyFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}