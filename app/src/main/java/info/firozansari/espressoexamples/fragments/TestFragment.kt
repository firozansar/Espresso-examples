package info.firozansari.espressoexamples.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import info.firozansari.espressoexamples.R
import info.firozansari.espressoexamples.TextSwapper

class TestFragment : Fragment() {
    private var mExampleText: TextView? = null
    private var mExampleButton: Button? = null
    private var mTextSwapper: TextSwapper? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_test, container, false)
        mTextSwapper = TextSwapper(resources.getString(R.string.example_text_before), resources.getString(R.string.example_text_after))
        mExampleText = rootView.findViewById<View>(R.id.test_fragment_example_text) as TextView
        mExampleButton = rootView.findViewById<View>(R.id.change_text_button) as Button
        mExampleButton!!.setOnClickListener { mExampleText?.text = mTextSwapper?.swap() }
        return rootView
    }

}