package com.udacity.shoestore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.login.FIRST_LOGIN_KEY
import com.udacity.shoestore.login.LoginFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.navHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            supportActionBar?.setDisplayHomeAsUpEnabled(true);
            when (destination.id) {
                R.id.loginFragment -> {
                    toolbar.title = "Login"
                    supportActionBar?.setDisplayHomeAsUpEnabled(false);
                }
                R.id.instructionsFragment -> toolbar.title = "Instructions"
                R.id.welcomeFragment -> toolbar.title = "Welcome"
                R.id.shoesListFragment -> toolbar.title = "Shoes List"
                R.id.detailFragment -> toolbar.title = "New Shoes"
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                navToLoginScreen()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun navToLoginScreen() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        sharedPref.edit {
            putBoolean(FIRST_LOGIN_KEY, true)
            commit()
        }
        findNavController(R.id.navHostFragment).navigate(R.id.action_global_loginFragment)
    }
}
