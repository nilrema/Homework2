package com.example.homework2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.homework2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val allTabs = binding.tabLayout

        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(allTabs, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.add)
                1 -> tab.text = getString(R.string.garage)
            }
        }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val title = when (position) {
                    0 -> getString(R.string.add)
                    1 -> getString(R.string.garage)
                    else -> getString(R.string.invalid_tab)
                }
                supportActionBar?.title = title
            }
        })

    }
}



