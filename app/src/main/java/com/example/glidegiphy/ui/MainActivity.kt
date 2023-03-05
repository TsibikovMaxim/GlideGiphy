package com.example.glidegiphy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.glidegiphy.databinding.ActivityMainBinding
import com.example.glidegiphy.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private val navController: NavController get() = findNavController(R.id.nav_host_fragment)
    override fun onSupportNavigateUp() = navController.navigateUp()
}