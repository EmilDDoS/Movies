package com.example.movie.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.movie.R
import com.example.movie.data.network.ApiFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenResumed {
            val data = ApiFactory().instance.getPopularApi()
            val textView = findViewById<TextView>(R.id.hello)
            textView.text = data.toString()
        }

    }
}