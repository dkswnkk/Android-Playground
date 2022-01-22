package com.example.choicelistdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.choicelistdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Singlle Choice List")
                .setSingleChoiceItems(
                    data1,
                    0
                ) { dialogInterface: DialogInterface, i: Int ->
                    Toast.makeText(
                        this,
                        data1[i],
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .setNegativeButton("취소", null)
                .setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                    val alert = dialogInterface as AlertDialog
                    val idx = alert.listView.checkedItemPosition
                    binding.textView.text = "${data1[idx]}"
                }.show()
        }
        binding.button2.setOnClickListener {
            val boolArray = booleanArrayOf(false, true, false, false, true)
            AlertDialog.Builder(this).setTitle("체크박").setMultiChoiceItems(
                data1,
//                boolArray
            null,
            ) { dialogInterface: DialogInterface, i: Int, b: Boolean ->
                if (b) {
                    Toast.makeText(this, "${data1[i]} 체크", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "${data1[i]} 체크해제", Toast.LENGTH_SHORT).show()
                }
            }.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                val alert = dialogInterface as AlertDialog
                val check = alert.listView.checkedItemPositions //체크가 된 것이 아닌 변경이 된 모든 항목을 저장함.
                binding.textView.text = ""
                for (i in 0 until check.size()) {
                    //체크 상태가 변경 된 항목의 인덱스 번호를 추출한다.
//                    Log.d("test1", "${i}")
                    var index = check.keyAt(i)
                    if(check.get(index)){
                        binding.textView.append("${data1[index]}    ")
                    }
                }
            }
                .show()
        }
    }
}