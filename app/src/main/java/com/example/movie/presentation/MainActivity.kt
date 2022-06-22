package com.example.movie.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.lifecycleScope
import com.example.movie.R
import com.example.movie.data.network.ApiFactory
import com.example.movie.databinding.ActivityMainBinding
import com.example.movie.presentation.screens.populate.PopulateMoviesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val fragment = PopulateMoviesFragment()
        supportFragmentManager.beginTransaction()
            .add(binding.container.id, fragment)
            .commit()*/

    }
}