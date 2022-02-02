package com.example.sqlitedatabase2

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlitedatabase2.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val helper = DBHelper(this)

            // 데이터 준비
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val now = sdf.format(Date())

            // 컬럼에 저장할 데이터를 관리하는 객체
            val cv1 = ContentValues()
            cv1.put("textData", "문자열1")
            cv1.put("intData", 100)
            cv1.put("floatData", 11.11)
            cv1.put("dateData", now)

            helper.writableDatabase.insert("TestTable", null, cv1)

            val cv2 = ContentValues()
            cv1.put("textData", "문자열2")
            cv1.put("intData", 200)
            cv1.put("floatData", 22.22)
            cv1.put("dateData", now)

            helper.writableDatabase.insert("TestTable", null, cv2)

            binding.textView.text = "저장완료"

        }

        binding.button2.setOnClickListener {
            val helper = DBHelper(this)

            val c1 = helper.writableDatabase.query("TestTable", null, null, null, null, null, null)

            binding.textView.text=""

            while(c1.moveToNext()){
                val idx1 = c1.getColumnIndex("idx")
                val idx2 = c1.getColumnIndex("textData")
                val idx3 = c1.getColumnIndex("intData")
                val idx4 = c1.getColumnIndex("floatData")
                val idx5 = c1.getColumnIndex("dateData")

                val idx = c1.getInt(idx1)
                val textData = c1.getString(idx2)
                val intData = c1.getInt(idx3)
                val floatData = c1.getDouble(idx4)
                val dateData = c1.getString(idx5)

                binding.textView.append("${idx}\n")
                binding.textView.append("${textData}\n")
                binding.textView.append("${intData}\n")
                binding.textView.append("${floatData}\n")
                binding.textView.append("${dateData}\n")

            }

            binding.button3.setOnClickListener {
                val helper = DBHelper(this)
                val cv = ContentValues()
                cv.put("textData","문자열")
                val where = "idx = ?"
                val args = arrayOf("1")

                helper.writableDatabase.update("TestTable",cv,where,args)
                binding.textView.text = "수정 완료"
            }

            binding.button4.setOnClickListener {
                val helper = DBHelper(this)

                val where = "idx =?"
                val args = arrayOf("1")

                // 테이블 명, 조건절, 조건절 ?에 바인딩 될 값 배열
                helper.writableDatabase.delete("TestTable",where,args)
                helper.writableDatabase.close()

                binding.textView.text = "삭제 완료"
            }

        }
    }
}