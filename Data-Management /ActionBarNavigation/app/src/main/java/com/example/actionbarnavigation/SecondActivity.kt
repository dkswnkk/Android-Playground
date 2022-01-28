package com.example.actionbarnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.actionbarnavigation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // HomeButton 메뉴를 활성화시킨다.
        supportActionBar?.setHomeButtonEnabled(true)
        // HomeButton을 노출 시킨다.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // HomeButton의 아이콘을 설정한다.
//        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_launcher_background)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}