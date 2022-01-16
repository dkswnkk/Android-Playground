package com.example.customlistview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("문자열1","문자열2","문자열3","문자열4","문자열5","문자열6")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this,R.layout.row,R.id.rowTextView1,data1)
        listView1.adapter = adapter1

        listView1.setOnItemClickListener { adapterView, view, i, l ->
            textView1.text = (i+1).toString() + "번째를 클릭했습니다."
        }
    }
}