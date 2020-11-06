package info.firozansari.espressoexamples.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import info.firozansari.espressoexamples.R
import info.firozansari.espressoexamples.fragments.TestFragment
import info.firozansari.espressoexamples.fragments.ViewPagerFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var mFragment: Fragment? = null
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout= findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        drawerLayout.setDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        displayFragment(mFragment)
    }

    fun displayFragment(frag: Fragment?) {
        var fragment = frag
        if (fragment == null) {
            fragment = TestFragment()
        }
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
//            val intent = Intent(this, AboutActivity::class.java)
//            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        var fragment: Fragment? = null
        if (id == R.id.nav_test) {
            fragment = TestFragment()
            supportActionBar?.setTitle("Basic Examples")
        } else if (id == R.id.nav_view_pager) {
            fragment = ViewPagerFragment()
            supportActionBar?.setTitle("View Pager Example")
        }
        if (fragment != null) {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragment)
            fragmentTransaction.commit()
        }
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
