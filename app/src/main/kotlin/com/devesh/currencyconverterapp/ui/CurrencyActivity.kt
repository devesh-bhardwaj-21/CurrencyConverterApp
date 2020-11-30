package com.devesh.currencyconverterapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.devesh.currencyconverterapp.R
import com.devesh.currencyconverterapp.databinding.CurrencyActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = CurrencyActivityBinding.inflate(layoutInflater)

        setSupportActionBar(binding.toolbar)

        val navHost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostfragment) as NavHostFragment

        val navController = navHost.navController

        setupActionBarWithNavController(navController)

        setContentView(binding.root)
    }
}
