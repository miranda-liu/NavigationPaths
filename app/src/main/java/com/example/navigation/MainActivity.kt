package com.example.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // using instance variables because the way the tutorial suggest
    // causes a crash
    // https://developer.android.com/codelabs/kotlin-android-training-add-navigation#7
    private lateinit var navController: NavController
    private lateinit var navHostFragment:NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // casting is done with the as keyword
        navHostFragment = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        // navigation drawer
        NavigationUI.setupWithNavController(navView, navController)

        // back button in the action bar which is called the "up button"
        NavigationUI.setupActionBarWithNavController(this,navController)

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}