package com.example.tablayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.adapter.FragmentStateAdapter as FragmentStateAdapter1

class MainActivity : FragmentActivity() {

    // ViewPager2에 세팅하기 위한 Fragment들을 가지고 있는 ArrayList
    val fragmentList = ArrayList<Fragment>()


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBar(binding.toolbar)
        binding.toolbar.setTitleTextColor(Color.WHITE)

        binding.tabs.setTabTextColors(Color.BLACK, Color.RED)
        binding.tabs.setSelectedTabIndicatorColor(Color.RED)

        for (i in 0..9) {
            val sub = SubFragment("${i}번째 Fragment")
            fragmentList.add(sub)
        }
        val adapter1 = object : FragmentStateAdapter1(this) {
            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }

            override fun getItemCount(): Int {
                return fragmentList.size
            }
        }
        binding.pager2.adapter = adapter1

        // tab과 viewpager를 연결한다.
        // material library 필수로 설치해야함
        TabLayoutMediator(binding.tabs, binding.pager2) { tab: TabLayout.Tab, i: Int ->
            tab.text="탭 ${i}"
        }.attach()
    }
}