package com.example.customadapter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*
import kotlin.run as run1

class MainActivity : AppCompatActivity() {
    val data1 = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5", "데이터6", "데이터7", "데이터8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView1.adapter = adapter1
    }

    val adapter1 = object : BaseAdapter() {
        override fun getCount(): Int {
            return data1.size
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        @SuppressLint("InflateParams", "SetTextI18n")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            // 재사용 가능한 View를 변수에 담는다.
            // 이때의 p1 즉 View는 read-only 임.
            var rowView = p1
            if (rowView == null) {
                rowView = layoutInflater.inflate(R.layout.row, null)
            }
             //항목 뷰에 내부에 배치되어 있는 뷰들의 주소값을 가져온다.
            val rowTextView1 = rowView?.findViewById<TextView>(R.id.rowTextView1)
            val button1 = rowView?.findViewById<Button>(R.id.rowButton1)
            val button2 = rowView?.findViewById<Button>(R.id.rowButton2)
            rowTextView1?.text = data1[p0]

            button1?.tag=p0
            button2?.tag=p0
            button1?.setOnClickListener {
                textView1.text = "${it.tag} 의 첫 번째 버튼을 눌렸습니다."
            }
            button2?.setOnClickListener {
                textView1.text ="${it.tag} 의 두 번째 버튼을 눌렸습니다."
            }

//            rowView?.run1 {
//                rowTextView1.text = data1[p0]
//                rowButton1.tag = p0
//                rowButton2.tag = p0
//
//                rowButton1.setOnClickListener {
//                    textView1.text = "첫 번쨰 버튼을 눌림. ${it.tag}"
//                }
//                rowButton2.setOnClickListener {
//                    textView1.text = "두 번째 버튼을 눌림. ${it.tag}"
//                }
//            }

            return rowView!!
        }
    }
}