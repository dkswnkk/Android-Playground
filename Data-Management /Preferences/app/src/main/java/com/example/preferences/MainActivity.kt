package com.example.preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.preferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // preferences 객체를 추출한다.
            // MODE_PRIVATE: 덮어씌우기, append: 추가하
            val pref = getSharedPreferences("data", Context.MODE_PRIVATE)

            // 데이엍 저장을 위한 객체를 추출한다.
            val editor = pref.edit()
            editor.putBoolean("data1", true).putFloat("data2", 11.11f).putInt("data3", 12312321)
                .putString("data4", "????ㅋ")

            val set = HashSet<String>()
            set.add("문자열1")
            set.add("문자열2")
            set.add("문자열3")

            editor.putStringSet("data5", set)
            editor.commit()
            binding.textView.text = "저장 완료"

        }
        binding.button2.setOnClickListener {
            val pref = getSharedPreferences("data", Context.MODE_PRIVATE)

            // 저장된 데이터를 가져온다.
            val data1 = pref.getBoolean("data1",false)
            val data2 = pref.getFloat("data2",0.0f)
            val data3 = pref.getInt("data3",0)
            val data4 = pref.getString("data4","데이터가없습니다.")
            val data5 = pref.getStringSet("data5",null)

            binding.textView.text = "${data1}\n"
            binding.textView.append("${data2}\n")
            binding.textView.append("${data3}\n")
            binding.textView.append("${data4}\n")
            binding.textView.append("${data5}\n")

        }
    }
}