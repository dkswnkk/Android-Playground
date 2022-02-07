package com.example.memoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import com.example.memoapp.databinding.ActivityMemoModifyBinding
import java.text.SimpleDateFormat
import java.util.*

class MemoModifyActivity : AppCompatActivity() {
    lateinit var binding: ActivityMemoModifyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoModifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.memoModifyToolbar)
        title = "메모 수정"

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val helper = DBHelper(this)

        val sql = """
            select memo_subject, memo_text
            from MemoTable
            where memo_idx =?
        """.trimIndent()

        val memo_idx = intent.getIntExtra("memo_idx", 0)
        val args = arrayOf(memo_idx.toString())

        val c1 = helper.writableDatabase.rawQuery(sql, args)
        c1.moveToNext()

        val memo_subject = c1.getString(c1.getColumnIndexOrThrow("memo_subject"))
        val memo_text = c1.getString(c1.getColumnIndexOrThrow("memo_text"))
        helper.writableDatabase.close()

        binding.modifyMemoSubject.setText(memo_subject)
        binding.modifyMemoText.setText(memo_text)

        Thread {
            SystemClock.sleep(300)

            runOnUiThread {
                binding.modifyMemoSubject.requestFocus()

                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(binding.modifyMemoSubject, InputMethodManager.SHOW_IMPLICIT)


            }
        }.start()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.modify_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            R.id.menu_modify_save -> {
                val DBHelper = DBHelper(this)

                val sql = """
                    update MemoTable
                    set memo_subject =?, memo_text =?, memo_date =?
                    where memo_idx = ?
                """.trimIndent()

                val now = System.currentTimeMillis()
                val sdf =
                    SimpleDateFormat("yyyy-MM-dd, HH:mm", Locale.KOREAN).format(now).format(Date())
                val args = arrayOf(
                    binding.modifyMemoSubject.text,
                    binding.modifyMemoText.text,
                    sdf,
                    intent.getIntExtra("memo_idx", 0)
                )

                DBHelper.writableDatabase.execSQL(sql, args)
                DBHelper.writableDatabase.close()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}