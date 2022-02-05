package com.example.memoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.memoapp.databinding.ActivityMemoAddBinding

class MemoAddActivity : AppCompatActivity() {
    lateinit var binding: ActivityMemoAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // toolbar 설정
        setSupportActionBar(binding.memoAddToolbar)
        title = "메모 추가"

        // 이전 버튼 설정
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }
}