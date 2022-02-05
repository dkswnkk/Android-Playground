package com.example.memoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.Menu
import android.view.MenuItem
import com.example.memoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SystemClock.sleep(2000)
        // Splash 화면 이후로 보여질 화면의 테마를 설정한다.
        setTheme(R.style.Theme_MemoApp)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val helper = DBHelper(this).writableDatabase.close()

        // Toolbar 설정
        setSupportActionBar(binding.mainToolbar)
        title = "메모 앱"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.main_menu_add->{
                val memo_add_intent = Intent(this,MemoAddActivity::class.java)
                startActivity(memo_add_intent)
            }
        }
        return true
    }
}