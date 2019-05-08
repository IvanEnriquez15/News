package pe.edu.upc.esfuerzo2.controllers.activities

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.fragment.app.Fragment
import pe.edu.upc.esfuerzo2.R
import pe.edu.upc.esfuerzo2.controllers.fragments.DahboardFragment
import pe.edu.upc.esfuerzo2.controllers.fragments.HomeFragment
import pe.edu.upc.esfuerzo2.controllers.fragments.NotificationsFragment

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navigateTo(navView.menu.findItem(R.id.navigation_home))
    }


    private fun getFragmentFor(item: MenuItem): Fragment {
        return when(item.itemId) {
            R.id.navigation_home -> HomeFragment()
            R.id.navigation_dashboard -> DahboardFragment()
            R.id.navigation_notifications -> NotificationsFragment()
            else -> HomeFragment()
        }
    }



    private fun navigateTo(item: MenuItem): Boolean {
        item.isChecked = true

        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, getFragmentFor(item))
            .commit() > 0
    }
}
