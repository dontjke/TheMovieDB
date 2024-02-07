package com.stepanov.themoviedb.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stepanov.themoviedb.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, MoviesFragment.newInstance())
            .commit()
    }
}