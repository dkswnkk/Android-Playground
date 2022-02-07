package com.example.memoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.memoapp.databinding.ActivityMemoReadBinding

class MemoReadActivity : AppCompatActivity() {
    lateinit var binding: ActivityMemoReadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.memoReadToolbar)
        title = "메모 읽기"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onResume() {
        super.onResume()

        val helper = DBHelper(this)
        val sql = """
            select memo_subject, memo_date, memo_text
            from MemoTable
            where memo_idx = ?
        """.trimIndent()

        // 글 번호 추출
        val memo_idx = intent.getIntExtra("memo_idx", 0)
        val args = arrayOf(memo_idx.toString())

        val c1 = helper.writableDatabase.rawQuery(sql, args)

        c1.moveToNext()

        // 메모 데이터를 가져온다.
        val memo_subject = c1.getString(c1.getColumnIndexOrThrow("memo_subject"))
        val memo_data = c1.getString(c1.getColumnIndexOrThrow("memo_date"))
        val memo_text = c1.getString(c1.getColumnIndexOrThrow("memo_text"))
        helper.writableDatabase.close()
        Log.d("test", memo_text)
        binding.memoReadSubject.text = memo_subject
        binding.memoReadDate.text = memo_data
        binding.memoReadText.text = memo_text

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            R.id.read_modify -> {
                val memo_idx = intent.getIntExtra("memo_idx", 0)
                val memoModifyIntent =
                    Intent(this, MemoModifyActivity::class.java).putExtra("memo_idx", memo_idx)
                startActivity(memoModifyIntent)

            }
            R.id.read_delete -> {

            }

        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.read_memu, menu)
        return true
    }
}