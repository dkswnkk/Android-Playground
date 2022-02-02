package com.example.sqlitedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sqlitedata.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("test","이까진 되네요")
        val helper = DBHelper(this)
        helper.writableDatabase.close()
        binding.button.setOnClickListener {
            val helper = DBHelper(this)
            val sql = """
            insert into TestTable(textData, intData, floatData, dateData)
            values(?,?,?,?)
        """.trimIndent()

            // ?에 바인딩될 값
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val now = sdf.format(Date())
            val arg1 = arrayOf("문자열1","100","11.11",now)
            val arg2 = arrayOf("문자열2","200","22.22",now)

            // 저장

            helper.writableDatabase.execSQL(sql,arg1)
            helper.writableDatabase.execSQL(sql,arg2)
            helper.writableDatabase.close()

            binding.textView.text = "저장 완료"
        }

        binding.button2.setOnClickListener {
            val helper = DBHelper(this)
            val sql = "select * from TestTable"

            // 쿼리 실행
            val c1 = helper.writableDatabase.rawQuery(sql,null)
            binding.textView.text=""
            while(c1.moveToNext()){
                // 가져올 컬럼의 인덱스 번호를 추출한다.
                val idx1 = c1.getColumnIndex("idx")
                val idx2 = c1.getColumnIndex("textData")
                val idx3 = c1.getColumnIndex("intData")
                val idx4 = c1.getColumnIndex("floatData")
                val idx5 = c1.getColumnIndex("dateData")

                // 데이터를 추출한다.

                val idx = c1.getInt(idx1)
                val textData = c1.getString(idx2)
                val intData = c1.getInt(idx3)
                val floatData = c1.getDouble(idx4)
                val dateData = c1.getString(idx5)

                binding.textView.append("idx:${idx}\n")
                binding.textView.append("textData:${textData}\n")
                binding.textView.append("intData:${intData}\n")
                binding.textView.append("floatData:${floatData}\n")
                binding.textView.append("dateData:${dateData}\n")

                helper.writableDatabase.close()
            }
        }

        binding.button3.setOnClickListener {
            val helper = DBHelper(this)
            val sql = "update TestTable set TextData = ? where idx = ?"
            val arg1 = arrayOf("문자열3","1")

            helper.writableDatabase.execSQL(sql,arg1)
            helper.writableDatabase.close()

            binding.textView.text = "업데이트 완료"
        }

        binding.button4.setOnClickListener {
            val helper = DBHelper(this)
            val sql = "delete from TestTable where idx = ?"
            val arg1 = arrayOf("1")

            helper.writableDatabase.execSQL(sql ,arg1)
            helper.writableDatabase.close()

            binding.textView.text = "삭제 완료"
        }
    }
}