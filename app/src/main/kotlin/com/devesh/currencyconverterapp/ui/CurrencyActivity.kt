package com.devesh.currencyconverterapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.devesh.currencyconverterapp.R
import com.devesh.currencyconverterapp.databinding.CurrencyActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyActivity : AppCompatActivity(R.layout.currency_activity) {

    private val binding by viewBinding(CurrencyActivityBinding::bind, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        val navHost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostfragment) as NavHostFragment
        val navController = navHost.navController
        setupActionBarWithNavController(navController)
    }
}
