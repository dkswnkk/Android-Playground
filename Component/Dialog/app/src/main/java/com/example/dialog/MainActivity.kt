package com.example.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import com.example.dialog.databinding.ActivityMainBinding
import com.example.dialog.databinding.CustomDialogBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var customDialogBinding: CustomDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        customDialogBinding = CustomDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            AlertDialog.Builder(this).setTitle("zz").setMessage("zzz")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("수락") { dialogInterface: DialogInterface, i: Int ->
                    binding.textView.text = "수락 버튼을 눌렸습니다."
                }
                .setNegativeButton("거절") { dialogInterface: DialogInterface, i: Int ->
                    binding.textView.text = "거절 버튼을 눌렸습니다."
                }.setNeutralButton("맨왼쪽") { dialogInterface: DialogInterface, i: Int ->
                    binding.textView.text = "Neutral버튼을 눌렸습니다."
                }.show()
        }
        binding.button2.setOnClickListener {
            AlertDialog.Builder(this).setTitle("커스텀 다이얼로그").setIcon(R.mipmap.ic_launcher)
                .setView(layoutInflater.inflate(R.layout.custom_dialog, null))
                .setNegativeButton("취소", null)
                .setPositiveButton("수락") { dialogInterface: DialogInterface, i: Int ->
                    run {
                        Log.d("test1", "${customDialogBinding.dialogText1.text}")
                        binding.textView.text = "${customDialogBinding.dialogText1.text}\n"
                        binding.textView.append("${customDialogBinding.dialogText1.text}")
//                            binding.textView.text="??"
                    }
                }.show()
        }
        binding.button3.setOnClickListener {
//                Calendar.getInstance().get(Calendar.YEAR).get(Calendar.MONTH).get()
//            val calendar = Calendar.getInstance().get(
            DatePickerDialog(
                this,
                { datePicker: DatePicker, i: Int, i1: Int, i2: Int ->
                    binding.textView.text = "${i} ${i1 + 1}월 ${i2} 일"
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DATE)
            ).show()
        }
        binding.button4.setOnClickListener {
            TimePickerDialog(
                this,
                { timePicker: TimePicker, i: Int, i1: Int ->
                    binding.textView.text = "${i}시 ${i1}분"
                },
                Calendar.getInstance().get(Calendar.HOUR),
                Calendar.getInstance().get(Calendar.MINUTE),
                true
            ).show()
        }

    }
}