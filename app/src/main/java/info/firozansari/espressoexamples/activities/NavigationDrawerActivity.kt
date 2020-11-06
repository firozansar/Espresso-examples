package info.firozansari.espressoexamples.activities

import android.content.res.Configuration
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import info.firozansari.espressoexamples.R
import info.firozansari.espressoexamples.fragments.NavigationFragment
import info.firozansari.espressoexamples.fragments.TestFragment

class NavigationDrawerActivity : AppCompatActivity() {
    private var mDrawerLayout: DrawerLayout? = null
    private var mDrawerToggle: ActionBarDrawerToggle? = null
    private lateinit var mMenuItems: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDrawerLayout = findViewById<View>(R.id.my_drawer_layout) as DrawerLayout
        mDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout, null, R.string.app_name, R.string.app_name)
        mDrawerLayout!!.setDrawerListener(mDrawerToggle)
        mMenuItems = arrayOf("Menu One", "Menu Two", "Menu Three", "Menu Four")
        val itemsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mMenuItems)
        val navigationList = findViewById<View>(R.id.navigation_menu) as ListView
        navigationList.onItemClickListener = NavigationDrawerClickListener()
        navigationList.adapter = itemsAdapter
        if (savedInstanceState == null) {
            //fragmentManager.beginTransaction().add(R.id.container, TestFragment(), TestFragment::class.java.simpleName).commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (mDrawerToggle!!.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mDrawerToggle!!.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mDrawerToggle!!.onConfigurationChanged(newConfig)
    }

    override fun onBackPressed() {
        if (mDrawerLayout!!.isDrawerOpen(Gravity.START or Gravity.LEFT)) {
            mDrawerLayout!!.closeDrawers()
            return
        }
        super.onBackPressed()
    }

    inner class NavigationDrawerClickListener : OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
            fragmentManager.beginTransaction().add(R.id.container,
                    NavigationFragment.newInstance(position, mMenuItems[position]), NavigationFragment.TAG)
                    .addToBackStack(NavigationFragment.TAG).commit()
            mDrawerLayout!!.closeDrawers()
        }
    }
}