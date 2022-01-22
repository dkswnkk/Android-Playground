package com.example.listdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.listdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7", "항목8")
    val data2 = arrayOf("ㅁ", "ㅠ", "ㅊ", "ㅇ", "ㄷ", "ㄹ", "ㅎ", "ㅗ")
    val data3 = intArrayOf(
        R.drawable.imgflag1,
        R.drawable.imgflag2,
        R.drawable.imgflag3,
        R.drawable.imgflag4,
        R.drawable.imgflag5,
        R.drawable.imgflag6,
        R.drawable.imgflag7,
        R.drawable.imgflag8,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            AlertDialog.Builder(this).setTitle("리스트 다이얼로").setNegativeButton("취소", null)
                .setItems(
                    data1,
                    { dialogInterface: DialogInterface, i: Int ->
                        binding.textView.text = i.toString()
                    }).show()
        }

        binding.button2.setOnClickListener {
            val list = ArrayList<HashMap<String?, Any>>()
            for (idx in data2.indices) {
                val map = HashMap<String?, Any>()
                map["data2"] = data2[idx]
                map["data3"] = data3[idx]
                list.add(map)
            }
            Log.d("test1", "${list}")
            val adapter = SimpleAdapter(
                this,
                list,
                R.layout.custom_list,
                arrayOf("data2", "data3"),
                intArrayOf(R.id.customTextView, R.id.customImageView)
            )

            AlertDialog.Builder(this).setAdapter(
                adapter,
                { dialogInterface: DialogInterface, i: Int -> Log.d("TEST", "${i}") })
                .setTitle("커스텀 리스트 다이얼로그")
                .setNegativeButton("취소", null).show()
        }


    }
}