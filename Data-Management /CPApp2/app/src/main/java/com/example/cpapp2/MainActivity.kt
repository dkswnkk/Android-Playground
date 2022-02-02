package com.example.cpapp2

import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cpapp2.databinding.ActivityMainBinding
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
            // Content Provider의 이름을 가지고 있는 uri 객체를 생성한다.
            val uri = Uri.parse("content://com.example.dbprovider")
            Log.d("test", "${uri}")
            // 첫 번째: 접속할 provider uri
            // 두 번째: 가져올 column 목록 배열, null이면 모두 가져온다.
            // 세 번째: 조건절
            // 네 번째: 조건절의 ?에 바인딩 될 값 배열
            // 다섯 번째: 정렬 기준
            val c1 = contentResolver.query(uri, null, null, null, null)
            Log.d("test", "1")
            binding.textView.text = ""
            Log.d("test", "$c1")
            while (c1?.moveToNext()!!) {
                Log.d("test", "2")
                // 가져올 컬럼의 인덱스 번호를 추출한다.
                val idx1 = c1?.getColumnIndex("idx")
                val idx2 = c1?.getColumnIndex("textData")
                val idx3 = c1?.getColumnIndex("intData")
                val idx4 = c1?.getColumnIndex("floatData")
                val idx5 = c1?.getColumnIndex("dateData")

                // 데이터를 추출한다.
                Log.d("test", "3")
                val idx = c1?.getInt(idx1)
                val textData = c1?.getString(idx2)
                val intData = c1?.getInt(idx3)
                val floatData = c1?.getDouble(idx4)
                val dateData = c1?.getString(idx5)
                Log.d("test", "4")
                binding.textView.append("idx:${idx}\n")
                binding.textView.append("textData:${textData}\n")
                binding.textView.append("intData:${intData}\n")
                binding.textView.append("floatData:${floatData}\n")
                binding.textView.append("dateData:${dateData}\n")
            }
            Log.d("test", "5")
        }
        binding.button2.setOnClickListener {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val now = sdf.format(Date())

            val cv1 = ContentValues()
            cv1.put("textData", "문자열3111")
            cv1.put("intData", 3000)
            cv1.put("floatData", 33.33)
            cv1.put("dateData", now)

            val cv2 = ContentValues()
            cv2.put("textData", "문자열42323232")
            cv2.put("intData", 4000)
            cv2.put("floatData", 44.44)
            cv2.put("dateData", now)

            val uri = Uri.parse("content://com.example.dbprovider")
            contentResolver.insert(uri, cv1)
            contentResolver.insert(uri, cv2)

            binding.textView.text = "저장 완료"
        }

        binding.button3.setOnClickListener {
            val cv = ContentValues()

            cv.put("textData","문자열1료1000")
            val where = "idx = ?"
            val args = arrayOf("1")

            val uri = Uri.parse("content://com.example.dbprovider")
            contentResolver.update(uri,cv,where,args)
            binding.textView.text="수정 완료"
        }

        binding.button4.setOnClickListener {
            val where = "idx = ?"
            val args = arrayOf("1")
            val uri = Uri.parse("content://com.example.dbprovider")

            contentResolver.delete(uri,where,args)
            binding.textView.text = "삭제 완료"
        }
    }
}