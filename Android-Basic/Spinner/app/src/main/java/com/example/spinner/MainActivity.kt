package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //어댑터를 생성한다. 접혔을 때의 모습을 구성할 Layout을 설정한다.
        val adapter1 = ArrayAdapter(this,android.R.layout.simple_spinner_item,data1)

        //펼쳐졌을 때의 모습을 구성하기 위한 Layout을 저장한다.

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter1

        button1.setOnClickListener {
            textView1.text = "선택한 항목 ${data1[spinner.selectedItemPosition]}"
        }
        spinner.onItemSelectedListener= listner1
    }
    val listner1 = object: AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when (p0?.id) {
                R.id.spinner -> {
                    textView1.text = "${data1[p2]}번째 항목이 선택되었습니다."
                }
            }
        }
        override fun onNothingSelected(p0: AdapterView<*>?) {

        }
    }
} 