package com.example.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    val fragList = arrayOf(SubFragment1(),SubFragment2(),SubFragment3())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBar(binding.toolbar)

        val adapter1 = object : FragmentStateAdapter(this){
            override fun createFragment(position: Int): Fragment {
              return fragList[position]
            }

            override fun getItemCount(): Int {
                return fragList.size
            }
        }
        binding.pager2.adapter = adapter1
    }
}