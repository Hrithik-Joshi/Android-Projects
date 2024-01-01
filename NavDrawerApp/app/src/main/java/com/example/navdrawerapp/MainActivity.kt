package com.example.navdrawerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.selectedItemId = R.id.home
        bottomNavigationView.setOnItemSelectedListener {
            it.isChecked = false
            when (it.itemId) {
                R.id.person -> {
                    replaceFragment(PersonFragment(), it.title.toString())
                }
                R.id.home -> {
                    replaceFragment(HomeFragment(), it.title.toString())
                }
                R.id.settings -> {
                    replaceFragment(SettingFragment(), it.title.toString())
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment, toString: String){
        val fragManager = supportFragmentManager
        val fragTrans = fragManager.beginTransaction()
        fragTrans.replace(R.id.flFragment, fragment)
        fragTrans.commit()
        title = title
    }
}