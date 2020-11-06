package info.firozansari.espressoexamples.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import info.firozansari.espressoexamples.R

class PagerFragment : Fragment() {
    private var mMessageText: String? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_page, container, false)
        mMessageText = if (savedInstanceState != null) {
            savedInstanceState.getString(PAGER_TEXT)
        } else {
            arguments?.getString(PAGER_TEXT)
        }
        val exampleText = rootView.findViewById<View>(R.id.example_text) as TextView
        exampleText.text = mMessageText
        return rootView
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(PAGER_TEXT, mMessageText)
        super.onSaveInstanceState(outState)
    }

    companion object {
        val TAG = PagerFragment::class.java.simpleName
        const val PAGER_TEXT = "PAGER_TEXT"
        fun newInstance(messageText: String?): PagerFragment {
            val fragment = PagerFragment()
            val bundle = Bundle()
            bundle.putString(PAGER_TEXT, messageText)
            fragment.arguments = bundle
            return fragment
        }
    }
}