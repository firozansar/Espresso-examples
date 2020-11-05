package info.firozansari.espressoexamples.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import info.firozansari.espressoexamples.R
import info.firozansari.espressoexamples.fragments.SwitchFragment

class SwitchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().add(R.id.container, SwitchFragment.newInstance()).commit()
        }
    }
}