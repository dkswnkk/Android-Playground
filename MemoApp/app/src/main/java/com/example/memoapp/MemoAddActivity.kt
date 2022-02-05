package com.example.memoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import com.example.memoapp.databinding.ActivityMemoAddBinding
import java.text.SimpleDateFormat
import java.util.*

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

        Thread {
            SystemClock.sleep(300)
            runOnUiThread {
                // 제목 입력창에 focus를 준다.
                binding.addMemoSubject.requestFocus()
                // 키보드를 올려준다.
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(binding.addMemoSubject, InputMethodManager.SHOW_IMPLICIT)
            }
        }.start()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            R.id.add_menu_write -> {
                val memo_subject = binding.addMemoSubject.text
                val memo_text = binding.addMemoText

                // query
                val sql = """
                    insert into MemoTable (memo_subject, memo_text, memo_date)
                    values(?, ?, ?)
                """.trimIndent()

                // database open
                val helper = DBHelper(this)

                // 현재 시간
                val now = System.currentTimeMillis()
                val sdf =
                    SimpleDateFormat("yyyy-MM-dd, HH:mm", Locale.KOREAN).format(now).format(Date())


                // ? 값 셋팅
                val arg1 = arrayOf(memo_subject, memo_text, sdf)
                helper.writableDatabase.execSQL(sql, arg1)
                helper.writableDatabase.close()
                finish()
            }
        }
        return true
    }
}