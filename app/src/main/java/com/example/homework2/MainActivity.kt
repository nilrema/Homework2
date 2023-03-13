package com.example.homework2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Fragment1())
            .commit()


        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_add -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Fragment1())
                        .commit()
                    true
                }
                R.id.navigation_garage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Fragment2())
                        .commit()
                    true
                }
                else -> false
            }
        }

    }
}




