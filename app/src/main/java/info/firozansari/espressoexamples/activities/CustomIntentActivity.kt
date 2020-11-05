package info.firozansari.espressoexamples.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import info.firozansari.espressoexamples.R

/**
 * Activity that is launched with a custom intent
 */
class CustomIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_intent)
        setTextView()
    }

    private fun setTextView() {
        val text = intent.extras!!.getString(CUSTOM_TEXT)
        val textView = findViewById<View>(R.id.custom_intent_textview) as TextView
        textView.text = text
    }

    companion object {
        const val CUSTOM_TEXT = "CUSTOM_TEXT"
        fun startActivity(originActivity: Activity, text: String?) {
            val intent = Intent(originActivity, CustomIntentActivity::class.java)
            intent.putExtra(CUSTOM_TEXT, text)
            originActivity.startActivity(intent)
        }
    }
}